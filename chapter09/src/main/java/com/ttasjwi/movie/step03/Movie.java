package com.ttasjwi.movie.step03;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step03.locator.ServiceLocator;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;


    /**
     * 서비스 로케이터 패턴 : 객체가 직접 ServiceLocator에게 의존성을 해결해줄 것을 요청
     * - 객체 내부에서 의존성을 감춰버린다.
     * - 의존성을 이해하기 위해 사용자는 객체 내부 구현을 이해해야한다.
     * - 의존성의 대상을 설정하는 시점과 해결되는 시점을 멀리 떨어트려 놓고 디버깅하기 힘들게 만듬
     * - 테스트 코드를 작성하기 어렵다.
     * - 암묵적인 의존성은 나쁘다. 가급적 생성자를 통해 명시적으로 의존성을 주입하도록 하자. 
     */
    public Movie(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = ServiceLocator.discountPolicy();
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
