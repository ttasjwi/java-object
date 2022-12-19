package com.ttasjwi.instrumented.step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstrumentedHashSetTest {

    @Test
    @DisplayName("상속으로 메서드 오버라이딩 오작용")
    public void test() {
        InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
        languages.addAll(Arrays.asList("Java", "Ruby", "Scala"));

        assertFalse(languages.getAddCount() == 3);
        assertTrue(languages.getAddCount() == 6);
    }
}
