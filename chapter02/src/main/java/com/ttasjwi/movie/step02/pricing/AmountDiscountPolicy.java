package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.DiscountCondition;
import com.ttasjwi.movie.step02.DefaultDiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

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
