package com.crackingthecodeinterview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.crackingthecodeinterview.chapter1.ZeroMatrix.zeroMatrix;

public class ZeroMatrixTest {
    @Test
    void zero_matrix_on_square_matrix() {
        int[][] input = {{0, 1, 2}, {1, 0, 2}, {1, 2, 0}};
        int[][] output = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        zeroMatrix(input);
        assertThat(input).isEqualTo(output);
    }

    @Test
    void zero_matrix_on_square_rectangle_matrix() {
        int[][] input = {{1, 2}, {1, 0}, {1, 2}, {1, 2}};
        int[][] output = {{1, 0}, {0, 0}, {1, 0}, {1, 0}};
        zeroMatrix(input);
        assertThat(input).isEqualTo(output);
    }

}