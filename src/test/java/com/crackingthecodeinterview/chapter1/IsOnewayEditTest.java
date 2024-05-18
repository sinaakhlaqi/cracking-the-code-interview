package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsOnewayEditTest {
    @ParameterizedTest
    @MethodSource("provideStringsForIsOnewayTest")
    void is_one_way_edit(String stringA, String stringB, boolean expected) {
        assertEquals(IsOnewayEdit.isOneWayEditV1(stringA, stringB), expected);
    }

    static Stream<Arguments> provideStringsForIsOnewayTest() {
        return Stream.of(
                Arguments.of("pale", "bale", true),
                Arguments.of("pale", "ale", true),
                Arguments.of("pale", "ble", false),
                Arguments.of("pale", "le", false)
        );
    }
}