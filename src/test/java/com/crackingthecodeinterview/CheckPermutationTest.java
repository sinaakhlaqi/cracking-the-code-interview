package com.crackingthecodeinterview;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;
import static com.crackingthecodeinterview.CheckPermutation.checkPermutation;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckPermutationTest {
    @Test
    void checkPermutationTest_OnNoNullStrings_ture() {
        String permuteStr1 = "abcde";
        String permuteStr2 = "deacb";
        assertThat(checkPermutation(permuteStr1, permuteStr2)).isTrue();
    }

    @Test
    void checkPermutationTest_OnNoNullStrings_false() {
        String nonPermuteStr1 = "apple";
        String nonPermuteStr2 = "wine";
        assertThat(checkPermutation(nonPermuteStr1, nonPermuteStr2)).isFalse();
    }

    @Test
    void checkPermutationTest_OnEmptyStrings_true() {
        assertThat(checkPermutation(EMPTY_STRING, EMPTY_STRING)).isTrue();
    }

    @Test
    void checkPermutationTest_OnEmptyStrings_false() {
        String inputString = "str";
        assertThat(checkPermutation(inputString, EMPTY_STRING)).isFalse();
    }
}