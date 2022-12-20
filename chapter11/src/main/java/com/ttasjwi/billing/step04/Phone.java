package com.ttasjwi.billing.step04;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    protected abstract Money calculateCallFee(Call call);

    protected Money afterCalculated(Money fee) {
        return fee;
    }
}
