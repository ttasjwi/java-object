package com.ttasjwi.billing.step05;

import com.ttasjwi.money.Money;

public class TaxablePolicy extends AdditionalRatePolicy {

    private double taxRatio;

    public TaxablePolicy(RatePolicy next, double taxRate) {
        super(next);
        this.taxRatio = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
