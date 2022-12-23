package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public class DurationDiscountPolicy extends BasicRatePolicy {

    private final List<DurationDiscountRule> rules = new ArrayList<>();

    public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
        this.rules.addAll(rules);
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for (DurationDiscountRule rule : rules) {
            result = result.plus(rule.calculate(call));
        }
        return result;
    }
}
