package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.DiscountPolicy;
import com.ttasjwi.movie.Screening;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmountDiscountPolicy implements DiscountPolicy {

    private final List<DiscountCondition> conditions = new ArrayList<>();
    private Money discountAmount;

    public AmountDiscountPolicy(List<DiscountCondition> conditions, Money discountAmount) {
        this.conditions.addAll(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public List<DiscountCondition> getConditions() {
        return Collections.unmodifiableList(conditions);
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
