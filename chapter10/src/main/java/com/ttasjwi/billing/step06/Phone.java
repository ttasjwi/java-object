package com.ttasjwi.billing.step06;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class Phone extends AbstractPhone {

    private Money amount; // 단위 요금
    private Duration seconds; // 단위 시간

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
