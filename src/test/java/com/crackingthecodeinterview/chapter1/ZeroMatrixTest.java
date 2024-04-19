package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static com.crackingthecodeinterview.chapter1.ZeroMatrix.zeroMatrixV1;

public class ZeroMatrixTest {
    //zeroMatrix success test case
    @Test
    void zero_matrix_v1_successfully() {
        int[][] mat1 = {{0, 1, 2}, {1, 0, 2}, {1, 2, 0}};
        int[][] out1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        int[][] mat2 = {{1, 2}, {1, 0}, {1, 2}, {1, 2}};
        int[][] out2 = {{1, 0}, {0, 0}, {1, 0}, {1, 0}};

        int[][] mat3 = {{1, 2, 0}, {1, 2, 0}, {1, 2, 0}};
        int[][] out3 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        int[][] mat4 = {{1, 1}, {1, 2}};
        int[][] out4 = {{1, 1}, {1, 2}};

        int[][] mat5 = {{0, 0, 0}, {1, 2, 3}, {1, 2, 3}};
        int[][] out5 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        zeroMatrixV1(mat1);
        zeroMatrixV1(mat2);
        zeroMatrixV1(mat3);
        zeroMatrixV1(mat4);
        zeroMatrixV1(mat5);
        zeroMatrixV1(null);

        assertThat(mat1).isEqualTo(out1);
        assertThat(mat2).isEqualTo(out2);
        assertThat(mat3).isEqualTo(out3);
        assertThat(mat4).isEqualTo(out4);
        assertThat(mat5).isEqualTo(out5);
        assertNull(null);
    }
}