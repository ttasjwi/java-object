package com.ttasjwi.movie.step02.pricing;

import com.ttasjwi.Money.Money;
import com.ttasjwi.movie.step02.DiscountPolicy;
import com.ttasjwi.movie.step02.Screening;

import java.time.LocalTime;

public class BrokenDiscountPolicy extends DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        checkPrecondition(screening);                 // 기존의 사전조건
        checkStrongerPrecondition(screening);         // 더 강력한 사전조건 -> 리스코프 치환 원칙 위반

        Money amount = screening.getMovieFee();
        checkPostcondition(amount);                   // 기존의 사후조건
        checkStrongerPostcondition(amount);           // 더 강력한 사후조건 -> 리스코프 치환 원칙 준수 (하지만 약한 사후조건은 리스코프 치환 원칙을 위반함)
        return amount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

    private void checkStrongerPrecondition(Screening screening) {
        assert screening.getEndTime().toLocalTime()
                .isBefore(LocalTime.MIDNIGHT);
    }

    private void checkStrongerPostcondition(Money amount) {
        assert amount.isGreaterThanOrEqual(Money.wons(1000));
    }

}
