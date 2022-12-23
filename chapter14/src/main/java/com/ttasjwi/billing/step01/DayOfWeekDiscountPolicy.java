package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;
import com.ttasjwi.time.DateTimeInterval;

import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy{

    private final List<DayOfWeekDiscountRule> rules = new ArrayList<>();

    public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
        this.rules.addAll(rules);
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for (DateTimeInterval interval : call.getInterval().splitByDay()) {
            for (DayOfWeekDiscountRule rule : rules) {
                result = result.plus(rule.calculate(interval));
            }
        }
        return result;
    }
}
