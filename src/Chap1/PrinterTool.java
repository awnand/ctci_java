package Chap1;

import java.util.Arrays;

public class PrinterTool {
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}