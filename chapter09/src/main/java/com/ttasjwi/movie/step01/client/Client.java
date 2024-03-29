package com.ttasjwi.movie.step01.client;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step01.Movie;
import com.ttasjwi.movie.step01.pricing.AmountDiscountPolicy;
import com.ttasjwi.movie.step01.pricing.SequenceCondition;

import java.time.Duration;

public class Client {
    public Money getAvatarFee() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10)));
        return avatar.getFee();
    }
}
