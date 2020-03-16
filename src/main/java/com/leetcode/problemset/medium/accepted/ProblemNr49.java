package com.leetcode.problemset.medium.accepted;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemNr49 {

    //https://leetcode.com/problems/group-anagrams/
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapListByKey = new HashMap<>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!mapListByKey.containsKey(key)){
                mapListByKey.put(key, new ArrayList<>());
            }
            List<String> list = mapListByKey.get(key);
            list.add(str);
        }
        return mapListByKey.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
    public static void main(String args[]) throws Exception {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

}
