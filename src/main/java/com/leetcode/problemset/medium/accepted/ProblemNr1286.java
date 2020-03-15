package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.CombinationIterator;

public class ProblemNr1286 {

    //https://leetcode.com/problems/iterator-for-combination/
    public static void main(String[] args){
        System.out.println("");
        CombinationIterator iterator = new CombinationIterator("chp", 1); // creates the iterator.

        /*System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false*/

        // ["CombinationIterator","hasNext","hasNext","next","next","hasNext","hasNext","next","hasNext","hasNext","hasNext"]
        // [["bvwz",2],[],[],[],[],[],[],[],[],[],[]]
        /*System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next());    //bv
        System.out.println(iterator.next());    //bw
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next());    //bz
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.hasNext()); // returns true*/

        //["CombinationIterator","hasNext","next","hasNext","hasNext","next","next","hasNext","hasNext","hasNext","hasNext"]
        //[["chp",1],[],[],[],[],[],[],[],[],[],[]]

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



  }
}
