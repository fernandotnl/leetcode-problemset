package com.leetcode.problemset.medium.accepted;

public class ProblemNr5 {

    //https://leetcode.com/problems/longest-palindromic-substring
    public static boolean isPalindrome(String sub, int startIndex, int endIndex){
        int length = endIndex - startIndex + 1;
        int half = length% 2 == 0 ? length/2: length/2;
        for (int i=0; i<=half; i++){
            char c1 = sub.charAt(startIndex+i);
            char c2 = sub.charAt(endIndex-i);
            if(c1 != c2){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length;
        int max = length;
        while(max>0){
            if (isPalindrome(s, i, j-1)) {
                return s.substring(i, j);
            }
            i++;
            j++;
            if(j > length){
                i=0;
                j=--max;
            }
        }
        return "";
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("babadab"));
    }
}
