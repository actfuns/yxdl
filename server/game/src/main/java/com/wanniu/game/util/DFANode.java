package com.wanniu.game.util;

import java.util.LinkedList;
import java.util.List;


class DFANode {
    private int value;
    private List<DFANode> subNodes;
    private boolean isLast;

    public DFANode(int value, boolean isLast) {
        this.value = value;
        this.isLast = isLast;
    }


    private DFANode addSubNode(DFANode subNode) {
        if (this.subNodes == null)
            this.subNodes = new LinkedList<>();
        this.subNodes.add(subNode);
        return subNode;
    }


    public DFANode addIfNoExist(int value, boolean isLast) {
        if (this.subNodes == null) {
            return addSubNode(new DFANode(value, isLast));
        }
        for (DFANode subNode : this.subNodes) {
            if (subNode.value == value) {
                if (!subNode.isLast && isLast)
                    subNode.isLast = true;
                return subNode;
            }
        }
        return addSubNode(new DFANode(value, isLast));
    }

    public DFANode querySub(int value) {
        if (this.subNodes == null) {
            return null;
        }
        for (DFANode subNode : this.subNodes) {
            if (subNode.value == value)
                return subNode;
        }
        return null;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }


    public int hashCode() {
        return this.value;
    }
}


