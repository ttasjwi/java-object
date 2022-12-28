package com.ttasjwi.movie;

import com.ttasjwi.money.Money;

import java.util.List;

public interface DiscountPolicy {

    default Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : getConditions()) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return screening.getMovieFee();
    }

    // 디폴트 메서드를 구성하기 위해 불필요하게 생겨난 퍼블릭 인터페이스들
    List<DiscountCondition> getConditions();
    Money getDiscountAmount(Screening screening);
}
