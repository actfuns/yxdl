package com.wanniu.game.mail;

import com.wanniu.core.GGame;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailGmData;
import com.wanniu.game.mail.po.ServerMailsPO;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerMailDataPO;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MailCenter {
    private static MailCenter instance;
    private ConcurrentHashMap<String, MailManager> mailDatas = new ConcurrentHashMap<>();


    private ConcurrentHashMap<String, MailGmData> serverMail = new ConcurrentHashMap<>();

    public static synchronized MailCenter getInstance() {
        if (instance == null)
            instance = new MailCenter();
        return instance;
    }


    public void onPlayerDisponse(String playerId) {
        this.mailDatas.remove(playerId);
    }

    public MailManager findPlayerMails(String playerId) {
        if (playerId == null)
            return null;
        if (this.mailDatas.containsKey(playerId)) {
            return this.mailDatas.get(playerId);
        }
        PlayerMailDataPO data = (PlayerMailDataPO) PlayerPOManager.findPO(ConstsTR.mailTR, playerId, PlayerMailDataPO.class);
        if (data == null) {
            data = new PlayerMailDataPO();
            PlayerPOManager.put(ConstsTR.mailTR, playerId, (GEntity) data);
        }
        MailManager mailManager = new MailManager(playerId, data);

        this.mailDatas.put(playerId, mailManager);
        return mailManager;
    }


    public void addMail(String playerId, WNMail mail, boolean isUpdateScript) {
        MailManager mailManager = findPlayerMails(playerId);
        if (mailManager != null)
            mailManager.addMail(mail, isUpdateScript);
    }

    public void sendOfflineMailToPlayers(String[] playerIds, MailData newMail, Const.GOODS_CHANGE_TYPE origin) {
        for (String playerId : playerIds) {
            WNMail mail = MailUtil.getInstance().createMail(newMail, playerId, origin);
            addMail(playerId, mail, false);
        }
    }

    public void checkServerMail(MailManager mailManager) {
        Map<String, String> serverMailRecord = mailManager.data.serverMailRecord;
        for (Map.Entry<String, MailGmData> entry : this.serverMail.entrySet()) {
            String key = entry.getKey();
            MailGmData gmail = entry.getValue();
            WNPlayer player = PlayerUtil.getOnlinePlayer(mailManager.playerId);

            if (gmail.createRoleDate != null && player.player.createTime.after(gmail.createRoleDate)) {
                continue;
            }
            if (player.getLevel() < gmail.minLevel) {
                continue;
            }

            if (!serverMailRecord.containsKey(key)) {
                WNMail mail = MailUtil.getInstance().createMail((MailData) gmail, mailManager.playerId, Const.GOODS_CHANGE_TYPE.GMT);
                addMail(mailManager.playerId, mail, true);
                mailManager.addServerMailRecord(key);
            }
        }
    }

    public void addServerMail(String serverMailId, MailGmData mailData, Const.GOODS_CHANGE_TYPE origin) {
        if (mailData.createRoleDate == null)
            return;
        this.serverMail.put(serverMailId, mailData);
        ServerMailsPO mailsData = new ServerMailsPO();
        mailsData.serverMail = this.serverMail;
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
        Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers();
        for (GPlayer player : players.values()) {
            WNPlayer wplayer = (WNPlayer) player;

            if (mailData.createRoleDate != null && wplayer.player.createTime.after(mailData.createRoleDate)) {
                continue;
            }
            if (wplayer.getLevel() < mailData.minLevel) {
                continue;
            }
            WNMail mail = MailUtil.getInstance().createMail((MailData) mailData, wplayer.getId(), origin);
            addMail(wplayer.getId(), mail, true);
            wplayer.mailManager.addServerMailRecord(serverMailId);
        }
        long endTime = mailData.createRoleDate.getTime() + 604800000L;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(endTime);
        Calendar now = Calendar.getInstance();
        long delay = c.getTimeInMillis() - now.getTimeInMillis();
        addDelayJob(serverMailId, delay);
    }


    public void removeServerMail(String serverMailId) {
        this.serverMail.remove(serverMailId);
        ServerMailsPO mailsData = new ServerMailsPO();
        mailsData.serverMail = this.serverMail;
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
    }

    public void loadServerMails() {
        ServerMailsPO mailsData = (ServerMailsPO) GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, ServerMailsPO.class);
        if (mailsData != null) {
            this.serverMail = mailsData.serverMail;
        } else {
            mailsData = new ServerMailsPO();
        }
        for (String serverMailId : this.serverMail.keySet()) {
            MailGmData mailData = this.serverMail.get(serverMailId);
            if (mailData.createRoleDate == null) {
                this.serverMail.remove(serverMailId);
                continue;
            }
            long endTime = mailData.createRoleDate.getTime() + 604800000L;
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(endTime);
            Calendar now = Calendar.getInstance();
            long delay = c.getTimeInMillis() - now.getTimeInMillis();
            if (delay < 0L) {
                this.serverMail.remove(serverMailId);
                continue;
            }
            addDelayJob(serverMailId, delay);
        }

        mailsData.serverMail = this.serverMail;
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, mailsData);
    }

    private void addDelayJob(String serverMailId, long delay) {
        JobFactory.addDelayJob(() -> {
            this.serverMail.remove(serverMailId);
            ServerMailsPO datas = new ServerMailsPO();
            datas.serverMail = this.serverMail;
            GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.serverMailsTR, datas);
        }delay);
    }
}


