package com.ttasjwi.money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyTest {

    @Test
    public void test1() {
        Money first = Money.wons(0);
        Money second = Money.wons(0);

        assertTrue(first.equals(second));
    }

    @Test
    public void test2() {
        Money first = Money.wons(0);
        Money second = Money.wons(10);

        assertTrue(first.isLessThan(second));
        assertTrue(first.isLessThanOrEquals(second));
    }

    @Test
    public void test3() {
        Money first = Money.wons(10);
        Money second = Money.wons(0);

        assertTrue(first.isGreaterThan(second));
        assertTrue(first.isGreaterThanOrEquals(second));
    }

}
