package com.ttasjwi.billing.step05;

import com.ttasjwi.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {

    private RatePolicy next; // 먼저 처리해야 할 요금제

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
