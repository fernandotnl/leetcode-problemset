package com.leetcode.problemset.medium.accepted;


public class ProblemNr48 {
    //https://leetcode.com/problems/rotate-image/
    public static void rotate(int[][] matrix) {
        int half = matrix.length/2;
        for(int i=0; i<half; i++){
            for(int j=i; j<matrix.length-1-i; j++){
                swapInverse(matrix, i, j);
            }
        }
    }

    public static void swapInverse(int[][] matrix, int i, int j){
        int jr = matrix.length - j - 1;
        int ir = matrix.length - i - 1;

        int aux1 = matrix[i][j];
        int aux2 = matrix[j][ir];
        int aux3 = matrix[ir][jr];
        int aux4 = matrix[jr][i];
        matrix[i][j] = aux4;
        matrix[j][ir] = aux1;
        matrix[ir][jr] = aux2;
        matrix[jr][i] = aux3;
    }

    public static void main(String args[]) throws Exception {
        int[][] matrix1 = {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
        };
        int[][] matrix2 = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        int[][] matrix3 = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        int[][] matrix4 = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36}
        };
        int[][] matrix5 = {
                {1,2,3,4,5,6,7},
                {8,9,10,11,12,13,14},
                {15,16,17,18,19,20,21},
                {22,23,24,25,26,27,28},
                {29,30,31,32,33,34,35},
                {36,37,38,39,40,41,42},
                {43,44,45,46,47,48,49}
        };
        printMatrix(matrix1);
        rotate(matrix1);
        printMatrix(matrix1);
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("Matrix:");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

}
