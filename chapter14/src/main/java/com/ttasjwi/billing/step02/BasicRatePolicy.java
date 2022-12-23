package com.ttasjwi.billing.step02;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public final class BasicRatePolicy implements RatePolicy {

    private final List<FeeRule> rules = new ArrayList<>();

    public BasicRatePolicy(List<FeeRule> rules) {
        this.rules.addAll(rules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                .stream()
                .map(call -> calculate(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

    private Money calculate(Call call) {
        return rules.stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
