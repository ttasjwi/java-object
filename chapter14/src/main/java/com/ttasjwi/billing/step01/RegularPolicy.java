package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {

    private Money amount;
    private Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds()/ seconds.getSeconds());
    }
}
