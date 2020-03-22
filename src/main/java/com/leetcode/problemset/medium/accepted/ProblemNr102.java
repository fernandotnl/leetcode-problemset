package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.TreeNode;

import java.util.*;

public class ProblemNr102 {

    //https://leetcode.com/problems/validate-binary-search-tree/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> listByLevel = new TreeMap<>(); //make sure the map will be order by level
        levelOrder(root, 0, listByLevel);
        return new ArrayList<>(listByLevel.values());
    }
    public static void levelOrder(TreeNode root, int level, Map<Integer, List<Integer>> listByLevel) {
        if(root == null) return;
        if(!listByLevel.containsKey(level)){
            listByLevel.put(level, new ArrayList<>());
        }
        List<Integer> list = listByLevel.get(level);
        list.add(root.val);
        levelOrder(root.left, level+1, listByLevel);
        levelOrder(root.right, level+1, listByLevel);
    }

    public static void main(String args[]) throws Exception {
        /*TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);*

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);*/

        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);*/


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

}
