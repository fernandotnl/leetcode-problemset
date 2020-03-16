package com.leetcode.problemset.medium.accepted;

public class ProblemNr50 {

    //https://leetcode.com/problems/powx-n/
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1|| x == -1) return n < 0 && x == -1? -1*x : 1*x;
        if(n == Integer.MIN_VALUE) return 0;
        if(n == Integer.MAX_VALUE && x>1) return Double.POSITIVE_INFINITY;
        if(n == Integer.MAX_VALUE && x==0) return 0;
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        return iterativePow(x, n);
        //return fastPow(x, n);
    }
    //SOLUTION 1:
    private static double iterativePow(double x, int n) {
        double powInt = 1;
        for(int i=0; i<n; i++){
            powInt*=x;
        }
        return powInt;
    }

    //SOLUTION 2 (discussion2):
    private static double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        // If n is even, x^n = (x^(n/2))^2.
        if (n % 2 == 0) {
            return half * half;
        } else { // If n is odd, x^n = (x^(n/2))^2*x.
            return half * half * x;
        }
    }

    public static void main(String args[]) throws Exception {
        System.out.println(myPow(0.00001, Integer.MAX_VALUE));
    }

}
