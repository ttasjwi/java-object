package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(List.of(conditions));
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
