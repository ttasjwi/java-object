package com.ttasjwi.instrumented.step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InstrumentedHashSetTest {

    @Test
    @DisplayName("부모 코드를 중복 작성해서 문제 해결...")
    public void test() {
        InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
        languages.addAll(Arrays.asList("Java", "Ruby", "Scala"));

        assertTrue(languages.getAddCount() == 3);
    }
}
