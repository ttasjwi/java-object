package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.DiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
