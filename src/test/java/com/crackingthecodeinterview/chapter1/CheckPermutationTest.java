package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;
import static com.crackingthecodeinterview.chapter1.CheckPermutation.checkPermutation;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckPermutationTest {
    //checkPermutation success test case
    @Test
    void check_permutation_successfully() {
        String permuteStr1 = "abcde";
        String permuteStr2 = "deacb";
        String nonPermuteStr1 = "apple";
        String nonPermuteStr2 = "wine";

        assertThat(checkPermutation(permuteStr1, permuteStr2)).isTrue();
        assertThat(checkPermutation(nonPermuteStr1, nonPermuteStr2)).isFalse();
        assertThat(checkPermutation(EMPTY_STRING, EMPTY_STRING)).isTrue();
        assertThat(checkPermutation(EMPTY_STRING, permuteStr1)).isFalse();
        assertThat(checkPermutation(null, permuteStr2)).isFalse();
        assertThat(checkPermutation(null, EMPTY_STRING)).isFalse();
    }
}