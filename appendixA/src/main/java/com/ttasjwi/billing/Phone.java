package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Phone {

    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Bill publishBill() {
        Money fee = ratePolicy.calculateFee(calls);
        return new Bill(this, fee);
    }

}
