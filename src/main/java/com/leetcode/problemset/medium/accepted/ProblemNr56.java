package com.leetcode.problemset.medium.accepted;

import java.util.*;

public class ProblemNr56 {


    //https://leetcode.com/problems/merge-intervals/
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        List<int[]> sortedIntervals = new ArrayList<>(Arrays.asList(intervals));
        sortedIntervals.sort(Comparator.comparingInt(i2 -> i2[0]));

        int[] aux = sortedIntervals.get(0);
        List<int[]> newIntervals = new ArrayList<>();
        newIntervals.add(aux);

        for(int i=1; i< sortedIntervals.size(); i++){
            if(aux[1] >= sortedIntervals.get(i)[0]){
                aux[0] = Math.min(aux[0], sortedIntervals.get(i)[0]);
                aux[1] = Math.max(aux[1], sortedIntervals.get(i)[1]);
            }
            else {
                aux = sortedIntervals.get(i);
                newIntervals.add(aux);
            }
        }

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }

    public static void main(String args[]) throws Exception {
        int[][] matrix = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        /*int[][] matrix = {
                {1,4},
                {0,1}
        };*/
        printMatrix(matrix);
        printMatrix(merge(matrix));
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("Matrix:");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

}
