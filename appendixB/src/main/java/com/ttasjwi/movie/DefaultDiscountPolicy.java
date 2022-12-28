package com.ttasjwi.movie;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(List<DiscountCondition> conditions) {
        this.conditions.addAll(conditions);
    }

    @Override
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
