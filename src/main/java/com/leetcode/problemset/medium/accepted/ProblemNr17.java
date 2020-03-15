package com.leetcode.problemset.medium.accepted;

import java.util.*;

public class ProblemNr17 {

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    static String[][] options = new String[10][4];

    public static List<String> letterCombinations(String digits) {

        options[2] = new String[] { "a", "b", "c"};
        options[3] = new String[] { "d", "e", "f"};
        options[4] = new String[] { "g", "h", "i"};
        options[5] = new String[] { "j", "k", "l"};
        options[6] = new String[] { "m", "n", "o"};
        options[7] = new String[] { "p", "q", "r", "s"};
        options[8] = new String[] { "t", "u", "v"};
        options[9] = new String[] { "w", "x", "y", "z"};

        return findCombination(digits, "", digits.length());
    }

    public static List<String> findCombination(String digits, String acc, int minSize){
        int length = digits.length();
        List<String> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            int pos = Integer.parseInt(String.valueOf(digits.charAt(i)));
            for(int j=0; j < options[pos].length; j++){
                String aux = acc + options[pos][j];
                if(i+1 == length){
                    if(minSize== aux.length()){
                        list.add(aux);
                    }
                }
                else {
                    String remainDigits = digits.substring(i+1, length);
                    list.addAll(findCombination(remainDigits, aux, minSize));
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println(letterCombinations("232"));
    }
}
