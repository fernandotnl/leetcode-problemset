package com.leetcode.problemset.medium.accepted;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNr36 {

    //https://leetcode.com/problems/valid-sudoku/
    private static List<Character> initializeList(){
        List<Character> list = new ArrayList<>();
        list.add('.');
        return list;
    }
    //SOLUTION 2:
    private static boolean isValidSudoku(char[][] board) {
        List<Character> charactersRow;
        List<Character> charactersColumn;
        List<List<Character>> listBox = new ArrayList<>();
        for(int k=0; k <9; k++){
            listBox.add(initializeList());
        }
        for(int i=0; i<9; i++){
            charactersRow = initializeList();
            charactersColumn = initializeList();
            for(int j=0; j<9; j++){
                char r = board[i][j];
                char c = board[j][i];
                if(!charactersRow.contains(r)){
                    charactersRow.add(r);
                }
                else if(r != '.') return false;
                if(!charactersColumn.contains(c)){
                    charactersColumn.add(c);
                }
                else if(c != '.') return false;
                int box = (i/3)*3 + (j/3);
                char b = board[i][j];

                List<Character> charactersBox = listBox.get(box);
                if(!charactersBox.contains(b)){
                    charactersBox.add(b);
                }
                else if(b != '.') return false;
            }
        }
        return true;
    }

    /*
    //SOLUTION 1:
    public static boolean isValidSudoku(char[][] board) {
        return checkRowsAndColumnsValid(board) && checkBoxValid(board);
    }

    private static boolean checkRowsAndColumnsValid(char[][] board) {
        List<Character> charactersRow;
        List<Character> charactersColumn;
        for(int i=0; i<9; i++){
            charactersRow = initializeList();
            charactersColumn = initializeList();
            for(int j=0; j<9; j++){
                char r = board[i][j];
                char c = board[j][i];
                if(!charactersRow.contains(r)){
                    charactersRow.add(r);
                }
                else if(r != '.') return false;
                if(!charactersColumn.contains(c)){
                    charactersColumn.add(c);
                }
                else if(c != '.') return false;
            }
        }
        return true;
    }

    private static boolean checkBoxValid(char[][] board) {
        List<Character> charactersBox;
        for(int k=0; k<9; k++){
            charactersBox = initializeList();
            int div = (k/3)*3;
            int mod = (k%3)*3;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int posR = i + div;
                    int posC = j + mod;
                    char b = board[posR][posC];
                    if(!charactersBox.contains(b)){
                        charactersBox.add(b);
                    }
                    else if(b != '.') return false;
                }
            }
        }
        return true;
    }*/

    public static void main(String args[]) throws Exception {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

}
