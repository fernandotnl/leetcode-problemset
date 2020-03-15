package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.LRUCache;

public class ProblemNr146 {

    //https://leetcode.com/problems/lru-cache/
    public static void main(String args[]) throws Exception {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        /*System.out.println(cache.get(2));      // returns -1
        cache.put(2,6);                        // next 6
        System.out.println(cache.get(1));      // return -1
        cache.put(1,5);                        // next 6
        cache.put(1,2);                        // next 6
        System.out.println(cache.get(1));      // returns 2
        System.out.println(cache.get(2));      // returns 6*/

        /*cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);                         //evicts 1
        System.out.println(cache.get(1));       //returns -1
        System.out.println(cache.get(2));       //returns 3*/
    }
}
