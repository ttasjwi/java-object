package com.ttasjwi.billing.step04;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class TaxableReuglarPhone extends RegularPhone {

    private double taxRate;

    public TaxableReuglarPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
