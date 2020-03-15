package com.leetcode.problemset.hard;

import com.leetcode.support.LFUCache;

public class ProblemNr460 {
    //https://leetcode.com/problems/lfu-cache
    public static void main(String args[]) throws Exception {
          /*LFUCache cache = new LFUCache(3);
          cache.put(2,2);
          cache.put(1,1);
          System.out.println(cache.get(2)); // 2
          System.out.println(cache.get(1)); // 1
          System.out.println(cache.get(2)); // 2
          cache.put(3, 3);
          cache.put(4, 4);
          System.out.println(cache.get(3)); // -1
          System.out.println(cache.get(2)); // 2
          System.out.println(cache.get(1)); // 1
          System.out.println(cache.get(4)); // 4*/

          /*LFUCache cache = new LFUCache(2);
          cache.put(2,2);
          cache.put(1,1);
          System.out.println(cache.get(1)); //1
          cache.put(3,3);
          System.out.println(cache.get(2)); //-1
          System.out.println(cache.get(3)); //3
          cache.put(4,4);
          System.out.println(cache.get(1)); //-1
          System.out.println(cache.get(3)); //3
          System.out.println(cache.get(4)); //4*/

          LFUCache cache = new LFUCache(3);
          cache.put(1,1);
          cache.put(2,2);
          cache.put(3,3);
          cache.put(4,4);
          System.out.println(cache.get(4));  //4
          System.out.println(cache.get(3));  //3
          System.out.println(cache.get(2));  //2
          System.out.println(cache.get(1));  //-1
          cache.put(5,5);
          System.out.println(cache.get(1));  //-1
          System.out.println(cache.get(2));  //2
          System.out.println(cache.get(3));  //3
          System.out.println(cache.get(4));  //-1
          System.out.println(cache.get(5));  //5
    }
}
