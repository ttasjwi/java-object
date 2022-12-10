package com.ttasjwi.movie.step04;

import com.ttasjwi.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;

    private final List<DiscountCondition> discountConditions = new ArrayList<>();

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition ... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions.addAll(List.of(discountConditions));
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected Money getFee() {
        return this.fee;
    }

    protected abstract Money calculateDiscountAmount();

}
