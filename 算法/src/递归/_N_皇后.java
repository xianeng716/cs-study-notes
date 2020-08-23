package 递归;

import java.util.ArrayList;
import java.util.List;

public class _N_皇后 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<String>> results = new _N_皇后().solveNQueens(4);
        System.out.println(results);
    }

    List<List<String>> results = new ArrayList<>();
    int[] cols;

    public List<List<String>> solveNQueens(int n) {
        placeQueens(n);
        return results;
    }

    /**
     * 数组索引是行号，数组元素是列号
     */

    void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
    }

    /**
     * 从第row行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            fill();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 第i行的皇后跟第row行第col列格子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    void fill() {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        results.add(list);
    }
}
