package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.chapter1.IsUnique.isUnique;
import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class IsUniqueTest {
    //isUnique success case test;
    @Test
    void is_unique_successfully() {
        String uniqueStr = "god";
        String nonUniqueStr = "good";

        assertThat(isUnique(uniqueStr)).isTrue();
        assertThat(isUnique(nonUniqueStr)).isFalse();
        assertThat(isUnique(EMPTY_STRING)).isTrue();
        assertThat(isUnique(null)).isFalse();
    }
}