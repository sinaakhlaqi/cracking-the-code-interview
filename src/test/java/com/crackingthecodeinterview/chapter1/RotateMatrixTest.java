package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.crackingthecodeinterview.chapter1.RotateMatrix.rotateMatrix;

public class RotateMatrixTest {
    //rotateMatrix success test case
    @Test
    void rotate_matrix_successfully() {
        int[][] mat1 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] mat2 = {{1, 1}, {2, 2}};
        int[][] mat3 = {{1, 1, 1}, {2, 2, 2}};
        int[][] mat4 = {{1}};

        int[][] out1 = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};
        int[][] out2 = {{2, 1}, {2, 1}};
        int[][] out3 = {{1, 1, 1}, {2, 2, 2}};
        int[][] out4 = {{1}};

        rotateMatrix(mat1);
        rotateMatrix(mat2);
        rotateMatrix(mat3);
        rotateMatrix(mat4);
        rotateMatrix(null);

        assertThat(mat1).isEqualTo(out1);
        assertThat(mat2).isEqualTo(out2);
        assertThat(mat3).isEqualTo(out3);
        assertThat(mat4).isEqualTo(out4);
        assertThat((int[][]) null).isEqualTo(null);
    }
}