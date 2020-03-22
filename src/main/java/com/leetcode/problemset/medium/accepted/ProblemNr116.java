package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNr116 {

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    static  Map<Integer, List<Node>> map = new HashMap<>();
    public static Node connect(Node root) {
        if(root == null) return null;
        return connectRec(root, 0);
    }
    public static Node connectRec(Node root, int level){

        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        List<Node> list = map.get(level);
        int size = list.size();
        list.add(root);
        if(size > 0){
            list.get(size-1).next = root;
        }
        if(root.left != null){
            connectRec(root.left, level+1);
        }
        if(root.right != null){
            connectRec(root.right, level+1);
        }
        return root;
    }

    public static void main(String args[]) throws Exception {
        //Input: root = [1,2,3,4,5,6,7]
        //Output: [1,#,2,3,#,4,5,6,7,#]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node perfect = connect(root);
        System.out.println(perfect);
    }

}
