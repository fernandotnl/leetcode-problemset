package com.leetcode.problemset.medium.accepted;


public class ProblemNr62 {

    //https://leetcode.com/problems/unique-paths/
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int maxRow = m-1;
        int maxCol = n-1;
        int[][] matrix = new int[m][n];
        for(int row=maxRow; row>=0; row--){
            for(int col=maxCol; col>=0; col--){
                if(col == maxCol && row == maxRow) continue;
                else if(col == maxCol || row == maxRow) matrix[row][col] = 1;
                else matrix[row][col] = matrix[row][col+1] + matrix[row+1][col];
            }
        }
        return matrix[0][1] + matrix[1][0];
    }

    public static void main(String args[]) throws Exception {
        System.out.println(uniquePaths(5,4));
    }

}
