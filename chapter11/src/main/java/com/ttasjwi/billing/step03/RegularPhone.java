package com.ttasjwi.billing.step03;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class RegularPhone extends Phone {

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
