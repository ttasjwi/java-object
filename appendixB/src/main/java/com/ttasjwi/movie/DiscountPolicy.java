package com.ttasjwi.movie;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(List<DiscountCondition> conditions) {
        this.conditions.addAll(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return screening.getMovieFee();
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
