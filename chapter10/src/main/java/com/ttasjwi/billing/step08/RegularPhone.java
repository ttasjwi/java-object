package com.ttasjwi.billing.step08;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class RegularPhone extends Phone {

    private Money amount; // 단위 요금
    private Duration seconds; // 단위 시간

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
