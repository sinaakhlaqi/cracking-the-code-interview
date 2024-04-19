package com.crackingthecodeinterview.chapter1;

import static com.crackingthecodeinterview.utilities.GeneralHelpers.*;

public class RotateMatrix {
    //1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    //    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    public static void rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length != matrix.length)
            return;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];
                matrix[layer][i] = matrix[last - offset][layer];
                matrix[last - offset][layer] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}