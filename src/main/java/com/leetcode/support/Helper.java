package com.leetcode.support;

public final class Helper {

    private Helper(){}

    public static void printArray(int[] array){
        System.out.println("\nArray:");
        for(int i=0; i<array.length; i++){
            System.out.print(" "+array[i]);
        }
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("\nMatrix:");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
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
