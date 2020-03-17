package com.leetcode.problemset.medium.accepted;

public class ProblemNr55 {

    //https://leetcode.com/problems/jump-game/
    static int[] tested;

    public static boolean canJump(int[] nums) {
        tested = new int[nums.length];
        return canJump(nums, 0);
    }

    private static boolean canJump(int[] nums, int next){
        int max = nums.length - 1;
        if(next >= max) return true;
        int jump = nums[next] + next <= max ? nums[next] : max - next;
        for(int i=jump; i>=1; i--){
            int nextJump = i + next;
            if(tested[nextJump] == 0){
                tested[nextJump] = 1;       //mark index as checked
                if(canJump(nums, nextJump)) return true;
            }
            else return false; //everything below that was already checked
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

}
