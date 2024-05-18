package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.chapter1.IsRotation.isRotationV1;
import static org.assertj.core.api.Assertions.assertThat;


public class IsRotationTest {
    //isRotation success test case
    @Test
    void is_rotation_v1() {
        String str1_1 = "championship";
        String str1_2 = "shipchampion";
        String str2_1 = "championship";
        String str2_2 = "shiphampion";
        String str3_1 = null;
        String str3_2 = "shipchampion";

        assertThat(isRotationV1(str1_1, str1_2)).isTrue();
        assertThat(isRotationV1(str2_1, str2_2)).isFalse();
        assertThat(isRotationV1(str3_1, str3_2)).isFalse();
    }
}