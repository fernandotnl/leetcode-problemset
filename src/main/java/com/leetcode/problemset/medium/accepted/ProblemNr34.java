package com.leetcode.problemset.medium.accepted;


import java.util.Arrays;
import java.util.stream.Collectors;

public class ProblemNr34 {

    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int[] result = {-1, -1};
        while(start<=end){
            int diff = end - start;
            int half = diff/2 + start;
            int halfValue = nums[half];

            if(halfValue == target){
                result[0] = findStart(nums, target, half);
                result[1] = findEnd(nums, target, half, end);
                return result;
            }
            else if(halfValue > target){
                end = half - 1;
            }
            else {
                start = half + 1;
            }
        }
        return result;
    }

    private static int findStart(int[] nums, int target, int actual) {
        int result = actual;
        int start = 0;
        int end = actual-1;

        while(start<=end){
            int diff = end - start;
            int half = diff/2 + start;
            int halfValue = nums[half];

            if(halfValue < target){
                start = half + 1;
            }
            else if(halfValue == target){
                end = half - 1;
                result = half;
            }
        }
        return result;
    }

    private static int findEnd(int[] nums, int target, int actual, int end) {
        int result = actual;
        int start = actual + 1;

        while(start<=end){
            int diff = end - start;
            int half = diff/2 + start;
            int halfValue = nums[half];

            if(halfValue > target){
                end = half - 1;
            }
            else if(halfValue == target){
                start = half + 1;
                result = half;
            }
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {1,1,2};
        System.out.println(Arrays.stream(searchRange(nums, 1)).boxed().collect(Collectors.toList()));
    }

}
