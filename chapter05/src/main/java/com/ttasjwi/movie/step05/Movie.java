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

    public Money calculateDiscountedFee() {
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

    public boolean checkDiscountable(Screening screening) {
        return discountConditions
                .stream()
                .anyMatch(condition -> condition.isDiscountable(screening));
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
