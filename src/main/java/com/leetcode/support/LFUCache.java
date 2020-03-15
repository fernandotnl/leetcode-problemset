package com.leetcode.support;

import java.time.LocalDateTime;
import java.util.*;

public class LFUCache {

    static class Wrapper{
        Integer key;
        Integer value;
        LocalDateTime lastUsed;
        Integer frequency;

        Wrapper(Integer key, Integer value, Integer frequency){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.lastUsed = LocalDateTime.now();
        }

        Integer getKey(){
            return this.key;
        }
        Integer getValue(){
            return this.value;
        }
        Integer getFrequency(){
            return this.frequency;
        }
        LocalDateTime getLastUsed(){
            return this.lastUsed;
        }
        void increase(){
            frequency++;
            this.lastUsed = LocalDateTime.now();
        }
    }

    private int capacity;
    PriorityQueue<Wrapper> priorityQueue;
    Map<Integer, Wrapper> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        if(capacity <= 0) return;
        priorityQueue =
            new PriorityQueue<>(
                this.capacity,
                    Comparator.comparingInt(Wrapper::getFrequency)
                            .thenComparing(Wrapper::getLastUsed));
        cache = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        if(this.capacity <= 0) return -1;
        if(cache.containsKey(key)){
            Wrapper val = cache.get(key);
            val.increase();
            priorityQueue.remove(val);
            priorityQueue.offer(val);
            return val.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.capacity <= 0 ) return;
        int frequency = 1;
        if(cache.containsKey(key)){
            Wrapper val = cache.get(key);
            priorityQueue.remove(val);
            frequency += val.frequency;
        }
        else if(priorityQueue.size() == capacity){
            Wrapper lastVal = priorityQueue.poll();
            cache.remove(lastVal.getKey());
        }
        Wrapper val = new Wrapper(key, value, frequency);
        cache.put(key, val);
        priorityQueue.offer(val);
    }
}