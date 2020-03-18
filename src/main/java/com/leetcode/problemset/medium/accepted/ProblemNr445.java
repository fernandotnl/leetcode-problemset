package com.leetcode.problemset.medium.accepted;

import com.leetcode.support.ListNode;

import java.util.Stack;

import static com.leetcode.support.Helper.printList;

public class ProblemNr445 {

    //https://leetcode.com/problems/add-two-numbers-ii/
    public static Stack<ListNode> buildStack(ListNode l1){
        ListNode aux = l1;
        Stack<ListNode> stack1 = new Stack<ListNode>();
        while(aux != null){
            stack1.push(aux);
            aux = aux.next;
        }
        return stack1;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode aux1 = l1;
        ListNode aux2 = l2;

        Stack<ListNode> stack1 = buildStack(l1);
        Stack<ListNode> stack2 = buildStack(l2);

        int carry = 0;
        ListNode old = null;
        ListNode result = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;

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
                result.next = old;
            }
            old = result;
            aux1 = aux1 == null ? null : aux1.next;
            aux2 = aux2 == null ? null : aux2.next;
        }
        if(carry == 1){
            result = new ListNode(1);
            if(old != null){
                result.next = old;
            }
        }
        return result;
    }

/*[2,4,3]
[5,6,4]*/
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
}
