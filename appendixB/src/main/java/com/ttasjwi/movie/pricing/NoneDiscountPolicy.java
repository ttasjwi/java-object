package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DiscountPolicy;
import com.ttasjwi.movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
