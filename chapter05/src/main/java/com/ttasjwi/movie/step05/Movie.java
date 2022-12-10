package com.ttasjwi.movie.step05;

import com.ttasjwi.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runnintTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        return isDiscountable(screening)
                ? calculateDiscountedFee()
                : fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions
                .stream()
                .anyMatch(condition -> condition.isDiscountable(screening));
    }

    private Money calculateDiscountedFee() {
        return switch (movieType) {
            case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee();
            case PERCENT_DISCOUNT -> calculatePercentDiscountedFee();
            case NONE_DISCOUNT -> calculateNoneDiscountedFee();
        };
    }

    private Money calculateAmountDiscountedFee() {
        return discountAmount;
    }

    private Money calculatePercentDiscountedFee() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountedFee() {
        return Money.ZERO;
    }

}
