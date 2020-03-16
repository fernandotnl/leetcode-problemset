package com.leetcode.problemset.medium.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemNr46 {

    //https://leetcode.com/problems/permutations/
    public static void permute(int[] nums, int next, List<List<Integer>> result){
        if(next == nums.length - 1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for(int i=next; i<nums.length; i++){
            swap(nums, i, next);
            permute(nums, next+1, result);
            swap(nums, next, i);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {1, 2};
        System.out.println(permute(nums));
    }

}
