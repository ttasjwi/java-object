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

    /**
     * 상속을 통해 할인 정책 로직을 구현하면, 컴파일 시점에 자식 클래스와 코드를 강하게 결합시켜버린다.
     * DiscountPolicy 인터페이스를 의존하면 할인 정책 구현을 한 곳에 캡슐화하고, 할인 정책을 교체하기 쉬워진다.
     *
     * 코드의 재사용을 위해서는 상속보다는 합성을 선호하는 것이 더 좋은 방법이다.
     */
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
