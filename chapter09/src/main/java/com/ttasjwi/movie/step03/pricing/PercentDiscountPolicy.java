package com.ttasjwi.movie.step03.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step03.DiscountCondition;
import com.ttasjwi.movie.step03.DiscountPolicy;
import com.ttasjwi.movie.step03.Screening;

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
