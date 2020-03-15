package com.leetcode.problemset.medium.accepted;

public class ProblemNr11 {

    //https://leetcode.com/problems/container-with-most-water
    public static int maxArea(int[] height) {
        int length = height.length;
        int last = length -1;
        int half = length /2;
        int max = 0;
        for(int i=last; i>=half; i--){
            for(int j=0; j<length; j++){
               max = Math.max(max,Math.min(height[i], height[j]) * (i - j));
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(height));
    }
}
