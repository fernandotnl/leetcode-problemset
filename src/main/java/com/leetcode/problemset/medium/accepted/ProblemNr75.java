package com.leetcode.problemset.medium.accepted;

import static com.leetcode.support.Helper.printArray;

public class ProblemNr75 {

    //https://leetcode.com/problems/sort-colors
    public static void sortColors(int[] nums) {
        int length = nums.length;
        int[] counter = new int[3];
        int half = length / 2;
        int fix = length % 2;
        for(int i=0; i<length; i++){
            int j = length-i-1;
            if(i<half){
                counter[nums[i]]++;
                counter[nums[j]]++;
            }
            else {
                if(fix == 1 && i == half){
                    counter[nums[i]]++; //count half when odd array
                }
                int blueMin = length - counter[2];
                int whiteMin = blueMin - counter[1];
                nums[j] = getColor(j, whiteMin, blueMin);
                nums[i] = getColor(i, whiteMin, blueMin);
            }
        }
    }

    public static int getColor(int i, int whiteMin, int blueMin){
        if(i < whiteMin){
            return 0;
        }
        else if(i < blueMin){
            return  1;
        }
        return 2;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {2,0,2,0,1,1,0};

        printArray(nums);
        sortColors(nums);
        printArray(nums);
    }

}
