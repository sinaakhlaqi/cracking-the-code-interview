package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;
import static com.crackingthecodeinterview.chapter1.IsPalindromePermutation.isPalindromePermutation;
import static org.assertj.core.api.Assertions.assertThat;

public class IsPalindromePermutationTest {
    @Test
    void is_palindrome_success() {
        String palindromeStr = "aaaabbbb";
        String nonPalindromeStr = "aaabbb";
        assertThat(isPalindromePermutation(palindromeStr)).isTrue();
        assertThat(isPalindromePermutation(nonPalindromeStr)).isFalse();
        assertThat(isPalindromePermutation(EMPTY_STRING)).isTrue();
        assertThat(isPalindromePermutation(null)).isFalse();
    }
}