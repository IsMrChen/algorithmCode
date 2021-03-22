package com.algorithm.array;

import java.util.HashMap;

/**
 * @program: algorithmCode
 * @description: 有效的数独
 * @packagename: com.algorithm.array
 * @author: Squirrel
 * @date: 2021-03-22 20:26
 **/
public class EffectiveSudokuArray {
    /**
     * 日期：2021-03-22
     * 解题思路：一次迭代
     * 可以使用 box_index = (row / 3) * 3 + columns / 3，其中 / 是整数除法
     * 如何确保行 / 列 / 子数独中没有重复项？
     * 可以利用 value -> count 哈希映射来跟踪所有已经遇到的值。
     *
     * 现在，我们完成了这个算法的所有准备工作：
     * 遍历数独。
     * 检查看到每个单元格值是否已经在当前的行 / 列 / 子数独中出现过：
     * 如果出现重复，返回 false。
     * 如果没有，则保留此值以进行进一步跟踪。
     * 返回 true
     */
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}
