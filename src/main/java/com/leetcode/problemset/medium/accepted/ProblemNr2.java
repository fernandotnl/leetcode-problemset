package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.ListNode;

public class ProblemNr2 {

    //https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode aux1 = l1;
        ListNode aux2 = l2;

        int carry = 0;
        ListNode old = null;
        ListNode result;
        ListNode first = null;
        while(aux1 != null || aux2 != null){
            int val1 = aux1 == null ? 0 : aux1.val;
            int val2 = aux2 == null ? 0 :aux2.val;

            int sum = val1 + val2 + carry;
            if(sum >= 10 ){
                carry = 1;
                sum-=10;
            }
            else {
                carry = 0;
            }
            result = new ListNode(sum);
            if(old != null){
                old.next = result;
            }
            old = result;
            aux1 = aux1 == null ? null : aux1.next;
            aux2 = aux2 == null ? null : aux2.next;
            if(first == null){
                first = result;
            }
        }
        if(carry == 1){
            result = new ListNode(1);
            if(old != null){
                old.next = result;
            }
        }
        return first;
    }

    public static void main(String[] args){

        ListNode i1 = new ListNode(2);
        ListNode i2 = new ListNode(4);
        ListNode i3 = new ListNode(3);
        i1.next = i2;
        i2.next = i3;

        ListNode l1 = i1;

        i1 = new ListNode(5);
        i2 = new ListNode(6);
        i3 = new ListNode(4);
        i1.next = i2;
        i2.next = i3;

        ListNode l2 = i1;

        printList(l1);
        printList(l2);
        printList(addTwoNumbers(l1,l2));

    }

    public static void printList(ListNode l1){
        System.out.println();
        ListNode aux = l1;
        do {
            System.out.print(String.format("%s -> ", aux.val));
            aux = aux.next;
        } while(aux.next != null);
        System.out.print(String.format("%s", aux.val));

    }
}
