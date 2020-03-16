package com.leetcode.problemset.medium.accepted;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProblemNr33 {

    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    /*
    SOLUTION: 1
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length-1, target);
    }

    public static int search(int[] nums, int start, int end, int target) {
        int diff = end-start;
        int half = diff/2 + start;
        int halfValue = nums[half];
        int startValue = nums[start];
        int endValue = nums[end];
        if(halfValue == target || startValue == target || endValue == target){
            if(halfValue == target){
                return half;
            }
            else if(startValue == target){
                return start;
            }
            else {
                return end;
            }
        }
        if(diff == 1) return -1;
        if(startValue < halfValue && target < halfValue && target > startValue){
            return search(nums, start, half, target);
        }
        else if (endValue > halfValue && target > halfValue && target < endValue){
            return search(nums, half, end, target);
        }
        else if(startValue > halfValue) {
            return search(nums, start, half, target);
        }
        else if(endValue < halfValue){
            return search(nums, half, end, target);
        }
        return -1;
    }
    */

    //SOLUTION 2:
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
              int diff = end - start;
              int half = diff / 2 + start;

              int halfValue = nums[half];
              int startValue = nums[start];
              int endValue = nums[end];

              if (halfValue == target) {
                  return half;
              }
              if (startValue <= halfValue){
                  if(target >= startValue && target < halfValue ) {
                    end = half - 1;
                  }
                  else {
                      start = half + 1;
                  }
              } else {
                  if(target > halfValue && target <= endValue ) {
                      start = half + 1;
                  }
                  else {
                      end = half -  1;
                  }
              }
        }
        return -1;
    }

    public static int[] shiftValues(int[] nums, int i){
        int length = nums.length;
        int[] aux = new int[length];
        for(int j=0; j <length; j++){
            int pos = j + i;
            if(pos >= length){
                pos-=length;
            }
            aux[pos] = nums[j];
        }
        return aux;
    }
    public static void main(String args[]) throws Exception {
        int[] nums = {1,3};
        //int[] nums = { 4, 5, 6, 7, 0, 1, 2};
        //nums = shiftValues(nums, 3);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println(search(nums, 3));
    }

}
