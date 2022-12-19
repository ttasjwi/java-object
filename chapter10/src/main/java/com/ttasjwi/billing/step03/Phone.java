package com.ttasjwi.billing.step03;

import com.ttasjwi.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type; // 요금제 타입

    private Money amount; // 단위 요금 (일반 요금일 때)
    private Money nightlyAmount; // 야간 단위 요금 (야간 요금제일 때)
    private Money regularAmount; // 일반 단위 요금 (야간 요금제일 때)
    private Duration seconds; // 단위 시간

    private final List<Call> calls = new ArrayList<>();

    /**
     * 일반 요금제
     */
    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    /**
     * 야간 요금제
     */
    public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, nightlyAmount, regularAmount, seconds);
    }

    public Phone(PhoneType type, Money amount, Money nightlyAmount,
                 Money regularAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return this.calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == PhoneType.REGULAR) {
                result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(
                            nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }
        return result;
    }
}
