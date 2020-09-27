package com.wanniu.game.equip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RepeatKeyMap<K, V>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    public static class Pair<K, V>
            implements Serializable {
        private static final long serialVersionUID = 6716065295786812835L;
        public K k;
        public V v;

        public Pair() {
        }

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    private List<Pair<K, V>> values = null;

    public List<Pair<K, V>> getValues() {
        return this.values;
    }

    public void clear() {
        if (this.values != null) {
            this.values.clear();
        }
    }

    public boolean isEmpty() {
        return (this.values == null || this.values.isEmpty());
    }

    public void setValues(List<Pair<K, V>> values) {
        this.values = values;
    }

    public static long getSerialversionuid() {
        return 1L;
    }

    public RepeatKeyMap() {
        this.values = new ArrayList<>();
    }

    public V put(K key, V value) {
        this.values.add(new Pair<>(key, value));
        return value;
    }


    public void putIfEmpty(K key, V value) {
        boolean hit = false;
        for (Pair<K, V> pair : this.values) {
            if (String.valueOf(pair.k).equals("0")) {
                pair.k = key;
                pair.v = value;
                hit = true;
                break;
            }
        }
        if (!hit) {
            this.values.add(new Pair<>(key, value));
        }
    }


    public void put(Pair<K, V> pair) {
        this.values.add(pair);
    }

    public List<K> keySet() {
        List<K> list = new ArrayList<>();
        for (Pair<K, V> pair : this.values) {
            list.add(pair.k);
        }
        return list;
    }

    public List<Pair<K, V>> entrySet() {
        return this.values;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Pair<K, V> pair : this.values) {
            sb.append(pair.k).append("=").append(pair.v).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public boolean containsKey(K key) {
        for (Pair<K, V> pair : this.values) {
            if (pair.k.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return this.values.size();
    }

    public static void main(String[] args) {
        RepeatKeyMap<Integer, Integer> tm = new RepeatKeyMap<>();
        for (int i = 1; i <= 10; i++) {
            tm.put(Integer.valueOf(100 + i), Integer.valueOf(100 * i));
        }

        System.out.println(tm.toString());
    }
}


