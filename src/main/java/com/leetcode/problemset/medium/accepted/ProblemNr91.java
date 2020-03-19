package com.leetcode.problemset.medium.accepted;

import java.util.HashMap;
import java.util.Map;

public class ProblemNr91 {

    //https://leetcode.com/problems/decode-ways/
    private static final char MIN_CODE = 1;
    private static final int MAX_CODE = 26;
    private static Map<String, Integer> patternWays;

    public static int numDecodings(String s) {
        patternWays = new HashMap<>();
        return numDecodingsRec(s);
    }

    public static int numDecodingsRec(String s) {
        int ways = 0;
        int min = Math.min(2, s.length());
        for(int length = 1; length <= min; length++){
            String value = s.substring(0, length);
            if(value.charAt(0) == '0') return 0;
            int intVal = Integer.parseInt(value);
            if(intVal>= MIN_CODE && intVal<= MAX_CODE){
                if(s.length() == length) {
                    return value.charAt(length - 1) == '0'? 1 : length; // have only 1 option
                }
                String pattern = s.substring(length);
                if(!patternWays.containsKey(pattern)){
                    int auxWays = numDecodings(pattern);
                    patternWays.put(pattern, auxWays);
                }
                ways += patternWays.get(pattern);
            }
        }
        return ways;
    }

    public static void main(String args[]) throws Exception {
    System.out.println(
        numDecodings(
            "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
        //System.out.println(listWays);
    }
}
