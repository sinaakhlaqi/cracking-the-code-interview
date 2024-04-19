package com.crackingthecodeinterview.chapter1;

import com.crackingthecodeinterview.exceptions.MalformedCharArrayException;
import org.junit.jupiter.api.Test;

import static com.crackingthecodeinterview.utilities.Constants.SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.crackingthecodeinterview.chapter1.URLify.urlify;

public class URLifyTest {

    //urlify success test case
    @Test
    void urlify_successfully() {
        char[] urlRaw = {'M', 'R', ' ', 'J', 'h', 'o', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        char[] urlify = {'M', 'R', '%', '2', '0', 'J', 'h', 'o', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'};
        urlify(urlRaw);
        assertThat(urlRaw).isEqualTo(urlify);
    }

    //urlify failure test case;
    @Test()
    void urlify_failure() {
        System.out.printf(SEPARATOR, "MalformedCharArrayException");
        char[] urlRaw = {'M', 'R', ' ', 'J', 'h', 'o', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' '};
        MalformedCharArrayException malformed = assertThrows(MalformedCharArrayException.class, () -> {
            urlify(urlRaw);
        });

        malformed.printStackTrace();
        System.out.printf(SEPARATOR, "NullPointerException");
        NullPointerException nullPointer = assertThrows(NullPointerException.class, () -> {
            urlify(null);
        });
        nullPointer.printStackTrace();
    }
}