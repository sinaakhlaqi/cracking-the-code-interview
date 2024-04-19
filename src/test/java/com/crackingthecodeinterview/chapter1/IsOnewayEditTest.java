package com.crackingthecodeinterview.chapter1;

import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.chapter1.IsOnewayEdit.isOneWayEditV1;
import static org.assertj.core.api.Assertions.assertThat;


public class IsOnewayEditTest {
    //onewayEdit success case;
    @Test
    void is_one_way_edit() {
        String str1 = "pale";
        String str2 = "bale";
        String str3 = "ale";
        String str4 = "ble";
        String str5 = "le";

        assertThat(isOneWayEditV1(str1, str2)).isTrue();
        assertThat(isOneWayEditV1(str1, str3)).isTrue();
        assertThat(isOneWayEditV1(str1, str4)).isFalse();
        assertThat(isOneWayEditV1(str1, str4)).isFalse();
        assertThat(isOneWayEditV1(str1, str5)).isFalse();
    }
}