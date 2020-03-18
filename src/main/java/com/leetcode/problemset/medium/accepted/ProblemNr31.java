package com.leetcode.problemset.medium.accepted;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProblemNr31 {

    //https://leetcode.com/problems/next-permutation
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while(i>=0 && nums[i+1] <= nums[i]) i--;

        if(i>=0){
            int j = length - 1;
            while(j>=0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public static void reverse(int[] nums, int i){
        int length = (nums.length - i)/2;
        for(int j=0; j<length; j++){
            swap(nums, i+j, nums.length-1-j);
        }
    }
    public static void swap(int[] nums, int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
