package Chap1;

import java.util.Arrays;
import java.util.HashSet;

import static Chap1.PrinterTool.printMatrix;

public class Prob8 {

    public static void zerofy(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int row: rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int column: columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

    private static void zerofyAndPrint(int[][] matrix) {
        System.out.println("Original:");
        printMatrix(matrix);
        zerofy(matrix);
        System.out.println("Zeroed:");
        printMatrix(matrix);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        int[] row1_1 = {1, 2, 3, 4};
        int[] row2_1 = {5, 0, 7, 8};
        int[] row3_1 = {9, 10, 11, 12};
        int[] row4_1 = {13, 3, 15, 16};

        int[] row1_2 = {1, 2, 3, 4};
        int[] row2_2 = {5, 0, 0, 8};
        int[] row3_2 = {9, 10, 0, 12};
        int[] row4_2 = {13, 3, 15, 16};

        int[][] matrix = {row1_1, row2_1, row3_1, row4_1};
        int[][] matrix2 = {row1_2, row2_2, row3_2, row4_2};

        zerofyAndPrint(matrix);
        zerofyAndPrint(matrix2);
    }
}
