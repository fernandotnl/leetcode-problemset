package com.leetcode.problemset.medium.accepted;


import java.util.ArrayList;
import java.util.List;

public class ProblemNr78 {

    //https://leetcode.com/problems/subsets
    public static List<List<Integer>> subsets(int[] nums) {
        int start = (int) Math.pow(2, nums.length);
        int end = (int) Math.pow(2, nums.length +1);
        List<List<Integer>> combinations = new ArrayList<>();
        for(int i=start; i<end; i++){
            String binary = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new ArrayList<>();
            for(int j=0; j < binary.length(); j++){
                if (binary.charAt(j) == "1".charAt(0)) {
                    list.add(nums[j]);
                }
            }
            combinations.add(list);
        }
        return combinations;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

}
