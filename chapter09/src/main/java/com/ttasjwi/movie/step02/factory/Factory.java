package com.ttasjwi.movie.step02.factory;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step02.Movie;
import com.ttasjwi.movie.step02.pricing.AmountDiscountPolicy;
import com.ttasjwi.movie.step02.pricing.SequenceCondition;

import java.time.Duration;

/**
 * - Factory : 구체적인 객체의 생성에 관한 책임을 Factory에 위임
 * - 도메인과 무관한 인공적인 객체를 PURE FABRICATION 이라고 한다.
 */

public class Factory {

    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10)));
    }
}
