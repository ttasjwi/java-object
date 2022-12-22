package com.ttasjwi.movie.step02;

import com.ttasjwi.Money.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    public Money calculateDiscountAmount(Screening screening) {

        checkPrecondition(screening); // 사전 조건 -> 메서드를 정상적으로 실행하기 위해 클라이언트가 만족시켜야 하는 것

        Money amount = Money.ZERO;
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                checkPostcondition(amount);
                return amount;
            }
        }

        amount = screening.getMovieFee();
        checkPostcondition(amount); // 사후 조건 : 메서드가 실행된 후에 서버가 클라이언트에게 보장해야하는 것
        return amount;
    }

    protected void checkPrecondition(Screening screening) {
        assert screening != null &&
                screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostcondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
