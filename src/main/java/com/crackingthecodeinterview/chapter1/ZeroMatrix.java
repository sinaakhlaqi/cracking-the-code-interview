package com.crackingthecodeinterview.chapter1;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
    /**
     * Transforms m*n matrix in such a way "if an entry in input matrix iz zero then
     * Its entire row and column should be zero. we call this matrix 'zero matrix'"
     * <em>
     * this api try's to solve problem 8
     * <p>
     * Problem Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
     * column are set to 0.
     *
     * @param matrix matrix will be transferred by the specified transformation
     *               {@code @Example}
     *               {                            {
     *               {0, 1, 2},                   {0, 0, 0},
     *               {1, 0, 2},--- Turns to ----> {0, 0, 0},
     *               {1, 2, 0}                    {0, 0, 0}
     *               }                            }
     * @apiNote this function could enhance in terms of space complexity. but I don't implement it
     */
    public static void zeroMatrix(int[][] matrix) {
        int[] zeroOffsets = findZeroOffsets(matrix);
        for (Integer offset : zeroOffsets) {
            int row = offset / matrix.length;
            int column = offset % matrix.length;
            for (int i = 0; i < matrix[0].length; i++)
                matrix[row][i] = 0;
            for (int k = 0; k < matrix.length; k++)
                matrix[k][column] = 0;
        }
    }

    //Helpers
    public static int[] findZeroOffsets(int[][] matrix) {
        Set<Integer> zeroSet = new HashSet<>();
        int zeroOffset;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                zeroOffset = i * matrix.length + j;
                if (!zeroSet.contains(zeroOffset)) {
                    if (matrix[i][j] == 0) {
                        zeroSet.add(zeroOffset);
                    }
                }
            }
        }
        return zeroSet.stream().mapToInt(ZeroMatrix::applyAsInt).toArray();
    }

    private static int applyAsInt(Integer element) {
        return element;
    }
}