package com.wanniu.game.guild.guidDepot;

import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.poes.PlayerBasePO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pomelo.guild.GuildManagerHandler;
import pomelo.item.ItemOuterClass;


public class EquipBag {
    public int bagGridCount;
    public Map<Integer, NormalItem> bagGrids;
    public int usedGridCount;
    public int bagTotalCount;

    public EquipBag(GuildBagItem bagItem) {
        _init(bagItem);
    }

    public void _init(GuildBagItem bagData) {
        this.bagGridCount = bagData.bagGridCount;
        this.bagGrids = new HashMap<>();
        this.usedGridCount = 0;

        Map<Integer, PlayerItemPO> grids = bagData.bagGrids;
        for (Integer key : grids.keySet()) {
            NormalItem item = ItemUtil.createItemByDbOpts(grids.get(key));
            if (item != null) {
                this.bagGrids.put(key, item);
                this.usedGridCount++;
            }
        }

        this.bagTotalCount = bagData.bagTotalCount;
    }

    public GuildBagItem toJson4Serialize() {
        GuildBagItem data = new GuildBagItem();

        for (int index = 1; index <= this.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {
                data.bagGrids.put(Integer.valueOf(index), item.cloneItemDB());
            }
        }

        data.bagGridCount = this.bagGridCount;
        data.bagTotalCount = this.bagTotalCount;
        return data;
    }

    public GuildManagerHandler.BagGridsInfo toJson4Payload() {
        GuildManagerHandler.BagGridsInfo.Builder data = GuildManagerHandler.BagGridsInfo.newBuilder();
        data.addAllBagGrids(getGrids4PayLoad());
        data.setBagGridCount(this.bagGridCount);
        data.setBagTotalCount(this.bagTotalCount);
        return data.build();
    }

    public NormalItem getItem(int index) {
        return this.bagGrids.get(Integer.valueOf(index));
    }

    public void _addUsedGridCount(int num) {
        if (num != 0) {
            this.usedGridCount += num;
        }
    }

    public boolean openGrid(int num) {
        if (num <= 0) {
            return false;
        }
        if (num + this.bagGridCount > this.bagTotalCount) {
            return false;
        }

        this.bagGridCount += num;
        return true;
    }


    public ArrayList<ItemOuterClass.Grid> getGrids4PayLoad() {
        ArrayList<ItemOuterClass.Grid> data = new ArrayList<>();
        for (int index = 1; index <= this.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {
                data.add(getGrid4PayLoad(index));
            }
        }
        return data;
    }

    public ItemOuterClass.Grid getGrid4PayLoad(int index) {
        ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
        grid.setGridIndex(index);
        NormalItem item = getItem(index);
        if (null != item) {
            grid.setItem(item.toJSON4GridPayload());
        }

        return grid.build();
    }

    public ArrayList<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad(PlayerBasePO basePO) {
        ArrayList<ItemOuterClass.ItemDetail> data = new ArrayList<>();
        for (int index = 1; index <= this.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {
                data.add(item.getItemDetail(basePO).build());
            }
        }
        return data;
    }

    public GuildDepotOneGrid getGridAndDetailByIndex(PlayerBasePO basePO, int index) {
        GuildDepotOneGrid data = new GuildDepotOneGrid();
        ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
        grid.setGridIndex(index);
        NormalItem item = getItem(index);
        if (null != item) {
            grid.setItem(item.toJSON4GridPayload());
            data.detail = item.getItemDetail(basePO).build();
        }

        return data;
    }


    public int emptyGridNum() {
        return this.bagGridCount - this.usedGridCount;
    }


    public ArrayList<Integer> findEmptyGrids(int num) {
        ArrayList<Integer> emptyIndex = new ArrayList<>();
        for (int i = 1; i <= this.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item == null) {
                emptyIndex.add(Integer.valueOf(i));
            }

            if (emptyIndex.size() == num) {
                break;
            }
        }
        return emptyIndex;
    }


    public boolean testEmptyGridLarge(int num) {
        if (emptyGridNum() >= num) {
            return true;
        }
        return false;
    }


    public int addItem(NormalItem item) {
        if (item == null) {
            return 0;
        }

        if (emptyGridNum() == 0) {
            return 0;
        }

        ArrayList<Integer> emptyIndexs = findEmptyGrids(1);
        if (emptyIndexs.size() <= 0) {
            return 0;
        }
        return addItemToPos(((Integer) emptyIndexs.get(0)).intValue(), item);
    }


    public int addItemToPos(int gridIndex, NormalItem item) {
        if (item != null) {
            NormalItem oldItem = getItem(gridIndex);
            if (oldItem == null) {
                this.bagGrids.put(Integer.valueOf(gridIndex), item);
                _addUsedGridCount(1);
                return gridIndex;
            }
        }
        return 0;
    }


    public int addItemByData(PlayerItemPO data) {
        NormalItem item = ItemUtil.createItemByDbOpts(data);
        if (item == null) {
            return 0;
        }
        return addItem(item);
    }


    public int addItemByPosData(int gridIndex, PlayerItemPO data) {
        NormalItem item = ItemUtil.createItemByDbOpts(data);
        if (item == null || gridIndex < 0) {
            return 0;
        }
        return addItemToPos(gridIndex, item);
    }

    public void _delete(int pos) {
        this.bagGrids.remove(Integer.valueOf(pos));
        _addUsedGridCount(-1);
    }


    public int removeItemByPos(int pos) {
        NormalItem item = getItem(pos);
        if (item != null) {
            _delete(pos);
            return pos;
        }
        return 0;
    }
}


