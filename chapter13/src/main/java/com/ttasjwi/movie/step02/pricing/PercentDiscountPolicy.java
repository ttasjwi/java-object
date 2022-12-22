package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.Money.Money;
import com.ttasjwi.movie.step02.DiscountCondition;
import com.ttasjwi.movie.step02.DiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {

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
