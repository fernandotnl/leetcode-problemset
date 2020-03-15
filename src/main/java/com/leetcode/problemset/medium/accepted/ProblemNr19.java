package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.ListNode;

public class ProblemNr19 {

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    //SOLUTION 1:
    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode aux = head;
        Stack<ListNode> stack = new Stack<>();
        for(; aux != null;aux=aux.next){
            stack.push(aux);
        }

        ListNode next = null;
        for(int i = 0; i<n; i++){
            aux = stack.pop();
            if(i == n - 1 ){
                if(aux.next == null && stack.isEmpty()){ //last one
                    return null;
                }
                else if(!stack.isEmpty()){
                    ListNode remove = aux;
                    aux = stack.pop();
                    remove.next = null;
                    aux.next = next;
                    return head;
                }
                else {
                    ListNode remove = aux;
                    aux = aux.next;
                    remove.next = null;
                    return aux;
                }
            }
            next = aux;
        }
        return head;
    }*/

    //SOLUTION 2:
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode aux = head;
        ListNode prev = aux;
        for(int i=0; i<n; i++){
            if(aux == null){
                return head;
            }
            aux = aux.next;
        }
        if(aux == null){
            aux = head;
            head = prev.next;
            aux.next = null;
            return head;
        }
        while(aux.next != null){
            aux = aux.next;
            prev = prev.next;
        }
        aux = prev.next;
        prev.next = aux.next;
        aux.next = null;
        return head;
    }

    public static void main(String args[]) throws Exception {

        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(2);
        ListNode i3 = new ListNode(3);
        ListNode i4 = new ListNode(4);
        ListNode i5 = new ListNode(5);

        i1.next = i2;
        i2.next = i3;
        i3.next = i4;
        i4.next = i5;
        ListNode list = i1;

        printList(removeNthFromEnd(list, 8));
    }

    public static void printList(ListNode l1){
        System.out.println();
        if(l1 == null){
            System.out.println("null");
            return;
        }
        ListNode aux = l1;
        do {
            System.out.print(String.format("%s -> ", aux.val));
            aux = aux.next;
        } while(aux != null && aux.next != null);
        if (aux != null) {
            System.out.print(String.format("%s", aux.val));
        }

    }
}
