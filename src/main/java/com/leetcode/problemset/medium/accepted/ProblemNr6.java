package com.leetcode.problemset.medium.accepted;

import java.util.HashMap;
import java.util.Map;

public class ProblemNr6 {

    //https://leetcode.com/problems/zigzag-conversion
    public static String convert(String s, int numRows) {
        if(s.length() == 0) return "";
        Map<Integer, StringBuilder> map =new HashMap<>();
        int lastRow = numRows - 1;
        int spacing = numRows > 2? 2 * (numRows - 1) : numRows;
        for(int k=0; k<s.length(); k++){
            int i = k % spacing;
            int diff = i - lastRow;
            if(i > lastRow){
                i = lastRow - diff;
            }
            if(!map.containsKey(i)){
                map.put(i, new StringBuilder());
            }
            StringBuilder sb = map.get(i);
            sb.append(s.charAt(k));
        }

        StringBuilder sb = new StringBuilder();
        for(int k=0; k <numRows; k++){
            if (map.containsKey(k)) {
                sb.append(map.get(k));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("AB", 2));
    }
}
