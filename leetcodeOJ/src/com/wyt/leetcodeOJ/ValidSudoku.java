package com.wyt.leetcodeOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyitao
 * @Date 2015-01-23
 * @version 1.0
 * @Description
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		
		char[][] a = {
				{'.','.','5','.','.','.','.','.','6'},
				{'.','.','.','.','1','4','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','9','2','.','.'},
				{'5','.','.','.','.','2','.','.','.'},
				{'.','.','.','.','.','.','.','3','.'},
				{'.','.','.','5','4','.','.','.','.'},
				{'3','.','.','.','.','.','4','2','.'},
				{'.','.','.','2','7','.','6','.','.'}
		};

		System.out.println(isValidSudoku(a));
	}
	
	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length !=9) {
			return false;
		}
		
		for (int i = 0; i < 9; i++) {//横
			Map<Character, Character> map = new HashMap<Character, Character>();
			for (int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if (map.containsKey(board[i][j])) {
						return false;
					} else {
						map.put(board[i][j], board[i][j]);
					}
				}
			}
		}
		
		for (int j = 0; j < 9; j++) {//竖
			Map<Character, Character> map = new HashMap<Character, Character>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (map.containsKey(board[i][j])) {
						return false;
					} else {
						map.put(board[i][j], board[i][j]);
					}
				}
			}
		}
		
		for (int i = 0; i < 9; i += 3) {//九宫
			Map<Character, Character> map1 = new HashMap<Character, Character>();
			for (int m = i; m < i+3; m++) {
				for (int j = 0; j < 3; j++) {
					if(board[m][j] != '.') {
						if (map1.containsKey(board[m][j])) {
							return false;
						} else {
							map1.put(board[m][j], board[m][j]);
						}
					}
				}
			}
			Map<Character, Character> map2 = new HashMap<Character, Character>();
			for (int m = i; m < i+3; m++) {
				for (int j = 3; j < 6; j++) {
					if(board[m][j] != '.') {
						if (map2.containsKey(board[m][j])) {
							return false;
						} else {
							map2.put(board[m][j], board[m][j]);
						}
					}
				}
			}
			
			Map<Character, Character> map3 = new HashMap<Character, Character>();
			for (int m = i; m < i+3; m++) {
				for (int j = 6; j < 9; j++) {
					if(board[m][j] != '.') {
						if (map3.containsKey(board[m][j])) {
							return false;
						} else {
							map3.put(board[m][j], board[m][j]);
						}
					}
				}
			}
		}
		
        return true;
    }
	
}
