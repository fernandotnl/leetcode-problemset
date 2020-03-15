package com.leetcode.support;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    private int capacity;
    List<Pair<Integer, Integer>> values;
    Map<Integer, Pair<Integer, Integer>> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        values = new ArrayList<>(capacity);
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Pair<Integer, Integer> val = cache.get(key);
            values.remove(val);
            values.add(0, val);
            return val.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Pair<Integer, Integer> val = cache.get(key);
            values.remove(val);
        }
        else if(values.size() == capacity){
            Pair<Integer, Integer> lastVal = values.get(capacity - 1);
            cache.remove(lastVal.getKey());
            values.remove(lastVal);
        }
        Pair<Integer, Integer> val = new Pair<>(key, value);
        cache.put(key, val);
        values.add(0, val);
    }
}