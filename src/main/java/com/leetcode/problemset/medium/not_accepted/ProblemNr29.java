package com.leetcode.problemset.medium.not_accepted;

public class ProblemNr29 {

    //https://leetcode.com/problems/divide-two-integers
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == divisor) return 1;
        if (-dividend == divisor) return -1;
        int division = 0;

        if(divisor == 2){
            return dividend >> 1;
        }
        if(divisor == -2){
            return -dividend+1 >> 1;
        }

        if(dividend == Integer.MIN_VALUE && divisor < 0) {
            dividend = Integer.MAX_VALUE;
            int oldDivisor = divisor;
            divisor -=oldDivisor;
            divisor -=oldDivisor;
        }
        if(divisor > 0 && dividend > 0){
            for(;dividend - divisor>=0; dividend-=divisor) division++;
        }
        else if(divisor < 0 && dividend > 0) {
            for (;dividend + divisor >= 0; dividend+=divisor) division--;
        }
        else if(divisor > 0){
            for (;dividend + divisor <= 0; dividend += divisor) division--;
        }
        else {
            for(;dividend - divisor <= 0; dividend -= divisor) division++;
        }
        return division;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(divide(-Integer.MIN_VALUE,Integer.MIN_VALUE));
    }
}
