package com.crackingthecodeinterview.chapter1;

import java.util.HashSet;
import java.util.Set;

import static com.crackingthecodeinterview.utilities.GeneralHelpers.*;

public class ZeroMatrix {
    //1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //    column are set to 0.
    //this function could enhance in terms of space complexity. but I don't implement it
    public static void zeroMatrixV1(int[][] matrix) {
        if (matrix == null)
            return;
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
        for (Integer offset : zeroSet) {
            int row = offset / matrix.length;
            int column = offset % matrix.length;
            for (int k = 0; k < matrix[0].length; k++)
                matrix[row][k] = 0;
            for (int k = 0; k < matrix.length; k++)
                matrix[k][column] = 0;
        }
    }
}