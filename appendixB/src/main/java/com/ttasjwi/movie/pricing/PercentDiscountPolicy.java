package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DefaultDiscountPolicy;
import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.Screening;

import java.util.List;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(List<DiscountCondition> conditions, double percent) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
