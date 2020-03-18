package com.leetcode.problemset.medium.accepted;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.support.Helper.printMatrix;

public class ProblemNr73 {

    //https://leetcode.com/problems/set-matrix-zeroes/
    public static void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        List<Integer> rowsToZero = new ArrayList<>();
        List<Integer> colsToZero = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                if(matrix[i][j] == 0){
                    if(!rowsToZero.contains(i)){
                        rowsToZero.add(i);
                    }
                    if(!colsToZero.contains(j)){
                        colsToZero.add(j);
                    }
                }
            }
        }
        for(Integer i: rowsToZero){
            matrix[i] = new int[numCols];
        }
        for(Integer j: colsToZero){
            for(int i=0; i<numRows; i++){
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        printMatrix(matrix);
        setZeroes(matrix);
        printMatrix(matrix);
    }


}
