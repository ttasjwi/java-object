package com.ttasjwi.movie.step01.pricing;


import com.ttasjwi.Money.Money;
import com.ttasjwi.movie.step01.DiscountCondition;
import com.ttasjwi.movie.step01.DiscountPolicy;
import com.ttasjwi.movie.step01.Screening;

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
