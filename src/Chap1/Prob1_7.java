package Chap1;
import static Chap1.PrinterTool.printMatrix;

public class Prob1_7 {

    public static void rotate(int[][] matrix) {
        int lower = 0;
        int upper = matrix.length - 1;
        while (lower < upper) {
            for (int offset = 0; lower + offset < upper; offset++) {
                int temp = matrix[lower][lower + offset];
                matrix[lower][lower + offset] = matrix[upper - offset][lower];
                matrix[upper - offset][lower] = matrix[upper][upper - offset];
                matrix[upper][upper - offset] = matrix[lower + offset][upper];
                matrix[lower + offset][upper] = temp;
            }
            lower++;
            upper--;
        }
    }

    private static void rotateAndPrint(int[][] matrix) {
        System.out.println("Original:");
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("Rotated:");
        printMatrix(matrix);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        int[] row1_1 = {1, 2, 3, 4};
        int[] row2_1 = {5, 6, 7, 8};
        int[] row3_1 = {9, 10, 11, 12};
        int[] row4_1 = {13, 14, 15, 16};

        int[] row1_2 = {1, 2, 3};
        int[] row2_2 = {4, 5, 6};
        int[] row3_2 = {7, 8, 9};

        int[][] matrix = {row1_1, row2_1, row3_1, row4_1};
        int[][] matrix2 = {row1_2, row2_2, row3_2};

        rotateAndPrint(matrix);
        rotateAndPrint(matrix2);

    }
}
