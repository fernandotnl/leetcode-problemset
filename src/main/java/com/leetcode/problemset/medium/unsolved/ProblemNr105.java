package com.leetcode.problemset.medium.unsolved;

import com.leetcode.support.TreeNode;

public class ProblemNr105 {

    static int pIndex;
    static int iIndex;

    //https://leetcode.com/problems/validate-binary-search-tree/
    //NOT my solution
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        pIndex = 0;
        iIndex = 0;
        return buildTree(preorder, inorder, null);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, TreeNode parent) {
        if(pIndex >= preorder.length || iIndex >= inorder.length) return null;

        TreeNode current = new TreeNode(preorder[pIndex]);
        pIndex++;
        if(inorder[iIndex] != current.val){
            current.left = buildTree(preorder, inorder, current);
        }

        iIndex++;
        if((parent == null) || inorder[iIndex] != parent.val){
            current.right = buildTree(preorder, inorder, parent);
        }
        return current;
    }

    public static void main(String args[]) throws Exception {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }

}
