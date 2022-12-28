package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.DiscountPolicy;
import com.ttasjwi.movie.Screening;

import java.util.Collections;
import java.util.List;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public List<DiscountCondition> getConditions() {
        return Collections.emptyList();
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
