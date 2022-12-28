package com.ttasjwi.movie.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.DiscountPolicy;
import com.ttasjwi.movie.Screening;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PercentDiscountPolicy implements DiscountPolicy {

    private final List<DiscountCondition> conditions = new ArrayList<>();
    private double percent;

    public PercentDiscountPolicy(List<DiscountCondition> conditions, double percent) {
        this.conditions.addAll(conditions);
        this.percent = percent;
    }

    @Override
    public List<DiscountCondition> getConditions() {
        return Collections.unmodifiableList(conditions);
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
