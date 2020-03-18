package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.ListNode;

import static com.leetcode.support.Helper.printList;

public class ProblemNr24 {

    //https://leetcode.com/problems/swap-nodes-in-pairs
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode aux = head;
        ListNode prev = null;
        ListNode next = head.next;
        int i =0;
        while(aux.next != null){
            if(i > 1){
                prev.next = next;
                aux.next = next.next;
                next.next = aux;
                prev = aux;
                if(aux.next != null){
                    aux = aux.next;
                    next = aux.next;
                }
            }
            else if(i == 1){
               prev.next = next;
               aux.next = prev;
               head = aux;
               aux = next;
               next = aux.next;
            }
            else if(i == 0){
                prev = aux;
                aux = aux.next;
                next = aux.next;
                if(next == null){
                    head = aux;
                    head.next = prev;
                    aux = prev;
                    aux.next = null;
                }
            }
            i++;
        }

        return head;
    }

    public static void main(String args[]) throws Exception {
        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(2);
        ListNode i3 = new ListNode(3);
        ListNode i4 = new ListNode(4);
        ListNode i5 = new ListNode(5);
        ListNode i6 = new ListNode(6);
        ListNode i7 = new ListNode(7);
        ListNode i8 = new ListNode(8);
        //i1.next = i2;
        //i2.next = i3;
        //i3.next = i4;
        //i4.next = i5;
        //i5.next = i6;
        //i6.next = i7;
        //i7.next = i8;
        ListNode list = i1;

        printList(swapPairs(list));
    }
}
