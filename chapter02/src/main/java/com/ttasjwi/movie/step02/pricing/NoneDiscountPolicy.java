package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.DiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

}
