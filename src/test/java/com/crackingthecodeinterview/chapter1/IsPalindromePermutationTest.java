package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;

public class IsPalindromePermutationTest {
    @ParameterizedTest
    @MethodSource("provideStringForIsPalindromeTest")
    void is_palindrome_test(String input, boolean expected) {
        assertEquals(IsPalindromePermutation.isPalindromePermutation(input), expected);
    }

    static Stream<Arguments> provideStringForIsPalindromeTest() {
        return Stream.of(
                Arguments.of("aaaabbbb", true),
                Arguments.of("aaabbb", false),
                Arguments.of(EMPTY_STRING, true),
                Arguments.of(null, false)
        );
    }
}