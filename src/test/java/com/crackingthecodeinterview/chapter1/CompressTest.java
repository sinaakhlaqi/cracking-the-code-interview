package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static com.crackingthecodeinterview.chapter1.Compress.compress;
import static org.assertj.core.api.Assertions.assertThat;

public class CompressTest {
    //compress test success case;
    @Test
    void compress_successfully() {
        String inputStr1 = "abbbaab";
        String inputStr2 = "ab";
        String inputStr3 = "a";

        assertThat(compress(inputStr1)).isEqualTo("ab3a2b");
        assertThat(compress(inputStr2)).isEqualTo("ab");
        assertThat(compress(inputStr3)).isEqualTo("a");
        assertNull(compress(null));
    }
}