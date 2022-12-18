package com.ttasjwi.movie.step01.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step01.DiscountCondition;
import com.ttasjwi.movie.step01.DiscountPolicy;
import com.ttasjwi.movie.step01.Screening;

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
