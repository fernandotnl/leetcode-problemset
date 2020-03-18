package com.leetcode.support;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    String characters;
    int combinationLength;
    int current = 0;
    List<String> listCombinations = new ArrayList<>();

    private int sum(String binary){
        int sum =0;
        for(int i=0; i<binary.length(); i++){
            sum+= Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        return sum;
    }

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        int start = (int) Math.pow(2, characters.length());
        int end = (int) Math.pow(2, characters.length() +1);
        for(int i=end-1; i>=start; i--){
            String binary = Integer.toBinaryString(i).substring(1);
            if (sum(binary) == combinationLength) {
                listCombinations.add(binary);
            }
        }
    }

    public String next() {
        String binary = this.listCombinations.get(current);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<characters.length(); i++){
            if (binary.charAt(i) == "1".charAt(0)) {
                sb.append(characters.charAt(i));
            }
        }
        current++;
        return sb.toString();
    }

    public boolean hasNext() {
        return current < listCombinations.size();
    }
}
