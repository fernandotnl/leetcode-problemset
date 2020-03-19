package com.leetcode.problemset.medium.accepted;

public class ProblemNr79 {

    //https://leetcode.com/problems/word-search/
    public static boolean exist(char[][] board, String word) {
        int numRows = board.length;
        int numCols = board[0].length;
        int[][] used = new int[numRows][numCols];
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                if(board[i][j] == word.charAt(0)
                        && exist(board, used, i, j, word)) return true;
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int[][] used, int i, int j, String word) {
        boolean exists = false;
        int numRows = board.length;
        int numCols = board[0].length;
        if(used[i][j] == 1) return false;

        if(board[i][j] == word.charAt(0)){
            if(word.length() == 1) return true; //found
            used[i][j] = 1;
            if(j+1 < numCols){
                exists = exist(board, used, i, j+1, word.substring(1)); // right
            }
            if(i+1 < numRows){
                exists = exists || exist(board, used, i+1, j, word.substring(1)); // bottom
            }
            if(j-1 >= 0){
                exists = exists || exist(board, used, i, j-1, word.substring(1)); // left
            }
            if(i-1 >= 0){
                exists = exists || exist(board, used, i-1, j, word.substring(1)); // top
            }
            used[i][j]=0;
        }
        return exists;
    }

    public static void main(String args[]) throws Exception {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "SEE"));
    }

}
