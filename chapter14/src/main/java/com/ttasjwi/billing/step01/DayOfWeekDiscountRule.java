package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;
import com.ttasjwi.time.DateTimeInterval;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountRule {

    private final List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private Duration duration = Duration.ZERO; // 단위 시간
    private Money amount = Money.ZERO; // 단위 요금

    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
        this.dayOfWeeks.addAll(dayOfWeeks);
        this.duration = duration;
        this.amount = amount;
    }

    /**
     * 해당 날짜가 조건을 만족시킬 경우 통화 요금을 적용하여 계산
     */
    public Money calculate(DateTimeInterval interval) {
        if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
            return amount.times(interval.duration().getSeconds() / duration.getSeconds());
        }
        return Money.ZERO;
    }
}
