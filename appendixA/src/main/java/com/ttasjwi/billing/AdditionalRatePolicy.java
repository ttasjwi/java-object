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

        // 사후조건 완화 -> 계약 위반 -> 리스코프 치환 원칙 위배
        // 사후조건 강화 -> 계약 준수 -> 리스코프 치환 원칙 준수
        assert result.isGreaterThanOrEqual(Money.wons(100));

        return result;
    }

    abstract protected Money afterCalculated(Money fee);
}
