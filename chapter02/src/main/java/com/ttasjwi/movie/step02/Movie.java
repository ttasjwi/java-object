package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        Money discountAmount = discountPolicy.calculateDiscountAmount(screening);
        Money fee = this.fee.minus(discountAmount);
        return fee;
    }
}
