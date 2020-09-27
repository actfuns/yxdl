package com.wanniu.game.solo;

import com.wanniu.core.game.LangService;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SoloNewsCO;
import com.wanniu.game.data.SoloRankCO;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SoloNewsHandler {
    private WNPlayer player;

    public SoloNewsHandler(WNPlayer player) {
        this.player = player;
    }


    public void onStraightWin(int contWinTimes) {
        for (SoloNewsCO prop : GameData.SoloNewss.values()) {
            if (prop.newsType == 1 && prop.newsPar == contWinTimes) {
                String news = _genWinNews(contWinTimes, prop.newsContent);
                SoloService.getInstance().addSoloNews(news);
                return;
            }
        }
    }


    public void onStraightWinStopped(int contWinTimes, String vsPlayerName) {
        for (SoloNewsCO prop : GameData.SoloNewss.values()) {
            if (prop.newsType == 2 && prop.newsPar == contWinTimes) {
                String news = _genWinStoppedNews(contWinTimes, vsPlayerName, prop.newsContent);
                SoloService.getInstance().addSoloNews(news);
                return;
            }
        }
    }


    public void onRankIdChanged(int rankId) {
        for (SoloNewsCO prop : GameData.SoloNewss.values()) {
            if (prop.newsType == 3 && prop.newsPar == rankId) {
                String news = _genRankIdUpNews(rankId, prop.newsContent);
                SoloService.getInstance().addSoloNews(news);
                return;
            }
        }
    }


    public void onGetGift(String typeStr, List<NormalItem> items) {
        for (NormalItem item : items) {
            if (item.isEquip()) {
                NormalEquip equip = (NormalEquip) item;
                for (SoloNewsCO prop : GameData.SoloNewss.values()) {
                    if (prop.newsType == 4 && equip.getQColor() >= prop.newsPar) {
                        String news = _genGetgiftNews(typeStr, (NormalItem) equip, prop.newsContent);
                        SoloService.getInstance().addSoloNews(news);
                        return;
                    }
                }
            }
        }
    }


    private static String getPlayerChatLink(WNPlayer player) {
        String playerLink = ChannelUtil.setPlayerInfo(player);
        String playerText = LangService.format("NAME_LINK", new Object[]{playerLink, player.getName()});
        return playerText;
    }


    private String _genWinNews(int contWinTimes, String originalNews) {
        String news = originalNews;

        String playerText = getPlayerChatLink(this.player);
        news = news.replace("{playerName}", playerText).replace("{straightwinNum}", "" + contWinTimes);
        news = System.currentTimeMillis() + "|" + news;
        return news;
    }


    private String _genWinStoppedNews(int contWinTimes, String vsPlayerName, String originalNews) {
        String news = originalNews;

        String playerText = getPlayerChatLink(this.player);
        news = news.replace("{playerName}", playerText).replace("{straightwinNum}", "" + contWinTimes);
        news = news.replace("{vsPlayerName}", vsPlayerName);
        news = System.currentTimeMillis() + "|" + news;
        return news;
    }


    private String _genRankIdUpNews(int rankId, String originalNews) {
        String news = originalNews;

        String playerText = getPlayerChatLink(this.player);
        String rankText = "" + rankId;
        SoloRankCO prop = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(rankId));
        if (prop != null) {


            rankText = "<font color=\"" + prop.textColour + "\">{a}</font>";
            rankText = rankText.replace("{a}", prop.rankName);
        }

        news = news.replace("{playerName}", playerText).replace("{RankName}", rankText);
        news = System.currentTimeMillis() + "|" + news;
        return news;
    }


    private String _genGetgiftNews(String typeName, NormalItem item, String originalNews) {
        String news = originalNews;

        String playerText = getPlayerChatLink(this.player);

        String allItemText = "";

        if (item != null) {
            String itemText = LangService.getValue(MessageUtil.getColorLink(item.prop.qcolor));
            String itemLink = ChannelUtil.setItemInfo(item);
            itemText = itemText.replace("{a}", item.prop.name).replace("{b}", itemLink);

            String numText = LangService.getValue("DEFAULT");
            numText = numText.replace("{a}", "*" + item.getNum());

            if (allItemText.equals("")) {
                allItemText = allItemText + itemText + numText;
            } else {
                allItemText = allItemText + "," + itemText + numText;
            }
        }

        news = news.replace("{playerName}", playerText).replace("{giftType}", typeName).replace("{item}", allItemText);

        news = System.currentTimeMillis() + "|" + news;
        return news;
    }


    public static Map<String, List<String>> getAllSoloNews(int logicServerId) {
        Map<String, List<String>> newsList = new TreeMap<>();
        List<String> newsAll = SoloService.getInstance().getAllSoloNews();


        for (String news : newsAll) {
            String[] str = news.split("\\|");
            Date date = new Date(Long.parseLong(str[0]));
            String strDate = DateUtil.format(date, "yyyy-MM-dd");

            String timeText = LangService.getValue("TIME_COLOUR");
            timeText = timeText.replace("{a}", "[" + strDate + "]");
            timeText = timeText + str[1];

            if (newsList.containsKey(strDate)) {
                List<String> list = newsList.get(strDate);
                list.add(timeText);
                continue;
            }
            List<String> values = new ArrayList<>();
            values.add(timeText);
            newsList.put(strDate, values);
        }

        return newsList;
    }
}


