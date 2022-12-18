package com.ttasjwi.movie.step03.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step03.DiscountCondition;
import com.ttasjwi.movie.step03.DiscountPolicy;
import com.ttasjwi.movie.step03.Screening;

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
