package com.leetcode.problemset.medium.accepted;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.support.Helper.printMatrix;

public class ProblemNr54 {

    //https://leetcode.com/problems/spiral-matrix/
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;

        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int row = minRow;
        int col = minCol;

        boolean changeRow = false;
        boolean increase = true;

        int total = maxRow * maxCol;
        int cont = 0;

        while(cont < total){
            result.add(matrix[row][col]);
            if(increase && changeRow && row + 1 < maxRow) { //Move to the Bottom
                row++;
                if(row+1 == maxRow){ //Change direction to left
                    changeRow = false;
                    increase = false;
                    maxCol--;
                }
            }
            else if(increase && !changeRow && col + 1 < maxCol) { //Move to the Right
              col++;
              if(col+1 == maxCol){ //Change direction to bottom
                  changeRow = true;
                  minRow++;
              }
            }
            else if(!increase && changeRow && row - 1 >= minRow) { //Move to the Top
                row --;
                if(row - 1 == minRow-1){ //Change direction to right
                    changeRow = false;
                    increase = true;
                    minCol++;
                }
            }
            else if(!increase && !changeRow && col - 1 >= minCol) { //Move to the Left
                col--;
                if(col-1 == minCol - 1){ //Change direction to top
                    changeRow = true;
                    maxRow--;
                }
            }
            else row++; //case for 1x2
            cont++;
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }; //[1,2,3,6,9,8,7,4,5]
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }; //[1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix3 = {
                {3},
                {2}
        };

        int[][] matrix4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        }; //[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]

        printMatrix(matrix4);
        System.out.println(spiralOrder(matrix4));
    }

}
