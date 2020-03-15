package com.leetcode.problemset.medium.accepted;

import java.util.ArrayList;
import java.util.List;

public class ProblemNr8 {

    //https://leetcode.com/problems/string-to-integer-atoi
    public static int myAtoi(String str){
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(int i =0; i<10; i++){
            String c = ""+i;
            list.add(c.charAt(0));
        }
        for(Character c: str.toCharArray()){
            if(list.contains(c) ||
                    (sb.length() == 0 && (c.equals("-".charAt(0)) || c.equals("+".charAt(0))))){
               sb.append(c);
               continue;
            }
            else if(sb.length() >= 1) break;
            else if(c.equals(" ".charAt(0))) continue;
            else if(c.equals(".".charAt(0))) break;
            return 0;
        }
        try {
            String s = sb.toString();
            boolean notValid = s.length() == 0 || s.equals("-") || s.equals("+");
            return notValid ? 0: Integer.valueOf(s);
        } catch (NumberFormatException f){
            return sb.toString().contains("-")? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args){
    System.out.println(myAtoi("0-1"));
    }
}
