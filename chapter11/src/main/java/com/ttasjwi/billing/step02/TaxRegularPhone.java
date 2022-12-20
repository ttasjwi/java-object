package com.ttasjwi.billing.step02;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class TaxRegularPhone extends RegularPhone {

    private double taxRate;

    public TaxRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }
}
