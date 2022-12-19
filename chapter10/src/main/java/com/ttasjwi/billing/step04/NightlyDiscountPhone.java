package com.ttasjwi.billing.step04;

import com.ttasjwi.money.Money;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        super(regularAmount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        Money result = super.calculateFee(); // 부모 클래스의 calculateFee 호출 -> 일반 요금을 적용했을 때의 요금
        Money nightlyFee = Money.ZERO; // 야간요금으로 적용할 것을 기본 요금제로 계산했을 때 추가적으로 지불해야하는 금액

        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(
                                call.getDuration().getSeconds() / getSeconds().getSeconds()));
            }
        }
        result.minus(nightlyFee); // 야간 요금으로 할인해야할 가격을 차감
        return result;
    }
}
