package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.util.List;

public abstract class AdditionalRatePolicy implements RatePolicy {

    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        changeNext(next);
    }

    protected void changeNext(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(List<Call> calls) {
        // 사전조건
        assert calls != null;

        Money fee = next.calculateFee(calls);
        Money result = afterCalculated(fee);

        // 사후조건
        assert result.isGreaterThanOrEqual(Money.ZERO);

        return result;
    }

    abstract protected Money afterCalculated(Money fee);
}
