package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.TreeNode;

public class ProblemNr98 {

    //https://leetcode.com/problems/validate-binary-search-tree/
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;
        if(lower != null && root.val <= lower) return false;
        if(upper != null && root.val >= upper) return false;

        if(!isValidBST(root.left, lower, root.val)) return false;
        return isValidBST(root.right, root.val, upper);
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

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        //5,1,4,null,null,3,6
        //10,5,15,null,null,6,20
        System.out.println(isValidBST(root));
    }

}
