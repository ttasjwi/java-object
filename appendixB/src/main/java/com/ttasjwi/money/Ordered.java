package com.ttasjwi.money;

public interface Ordered<T> extends Comparable<T> {

    int compare(T other);

    default boolean isLessThan(T other) {
        return this.compare(other) < 0;
    }

    default boolean isGreaterThan(T other) {
        return this.compare(other) > 0;
    }

    default boolean isLessThanOrEquals(T other) {
        return this.compare(other) <= 0;
    }

    default boolean isGreaterThanOrEquals(T other) {
        return this.compare(other) >= 0;
    }

    @Override
    default int compareTo(T other) {
        return compare(other);
    }

}
