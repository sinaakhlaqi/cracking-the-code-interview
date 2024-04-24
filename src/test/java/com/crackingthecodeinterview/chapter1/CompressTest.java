package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.chapter1.Compress.compress;
import static org.assertj.core.api.Assertions.assertThat;

public class CompressTest {
    //compress test success case;
    @Test
    void testCompress_onSmallerResult_returnCompressed() {
        String inputStr1 = "abbbaab";
        assertThat(compress(inputStr1)).isEqualTo("ab3a2b");
    }@Test
    void testCompress_onNotSmallerResult_returnOriginal() {
        String inputStr = "abababab";
        assertThat(compress(inputStr)).isEqualTo("abababab");
    }
}