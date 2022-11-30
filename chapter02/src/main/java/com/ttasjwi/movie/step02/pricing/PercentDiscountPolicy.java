package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.DiscountCondition;
import com.ttasjwi.movie.step02.DefaultDiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
