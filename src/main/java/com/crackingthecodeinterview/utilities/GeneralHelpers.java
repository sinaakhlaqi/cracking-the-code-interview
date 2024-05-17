package com.crackingthecodeinterview.utilities;

public class GeneralHelpers {
    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", ints[j]);
            }
            System.out.println("\n");
        }
    }
}
