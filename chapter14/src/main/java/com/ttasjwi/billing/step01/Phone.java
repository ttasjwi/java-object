package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private RatePolicy ratePolicy;
    private final List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

}
