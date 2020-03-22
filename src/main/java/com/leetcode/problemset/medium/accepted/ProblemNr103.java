package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.TreeNode;

import java.util.*;

public class ProblemNr103 {

    //https://leetcode.com/problems/validate-binary-search-tree/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> listByLevel = new TreeMap<>(); //make sure the map will be order by level
        zigzagLevelOrder(root, 0, listByLevel);
        return new ArrayList<>(listByLevel.values());
    }
    public static void zigzagLevelOrder(TreeNode root, int level, Map<Integer, LinkedList<Integer>> listByLevel) {
        if(root == null) return;
        if(!listByLevel.containsKey(level)){
            listByLevel.put(level, new LinkedList<>());
        }

        LinkedList<Integer> list = listByLevel.get(level);

        if (level % 2 == 0) list.addLast(root.val);
        else list.addFirst(root.val);

        zigzagLevelOrder(root.left, level+1, listByLevel);
        zigzagLevelOrder(root.right, level+1, listByLevel);
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


        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //[1,2,3,4,null,null,5]
        //[[1],[3,2],[4,5]]
        System.out.println(zigzagLevelOrder(root));
    }

}
