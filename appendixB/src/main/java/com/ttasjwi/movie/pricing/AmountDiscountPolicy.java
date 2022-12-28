package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DefaultDiscountPolicy;
import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.Screening;

import java.util.List;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(List<DiscountCondition> conditions, Money discountAmount) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
