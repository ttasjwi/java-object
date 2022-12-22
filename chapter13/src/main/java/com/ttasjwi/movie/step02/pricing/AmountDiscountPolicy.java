package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.Money.Money;
import com.ttasjwi.movie.step02.DiscountCondition;
import com.ttasjwi.movie.step02.DiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
