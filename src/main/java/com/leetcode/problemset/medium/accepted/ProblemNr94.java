package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.TreeNode;
import java.util.*;

public class ProblemNr94 {

    //https://leetcode.com/problems/binary-tree-inorder-traversal/
    //SOLUTION 1:
    /*public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }*/

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode aux = root;
        do {
            for(TreeNode left = aux; left != null; left=left.left){
                stack.add(left);
            }
            aux = stack.pop();
            result.add(aux.val);
            aux = aux.right;
        } while(aux!= null || !stack.isEmpty());
        return result;
    }


    public static void main(String args[]) throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        //TreeNode root = new TreeNode(2);
        //root.left = new TreeNode(3);
        //root.left.left= new TreeNode(1);
        System.out.println(inorderTraversal(root));
    }

}
