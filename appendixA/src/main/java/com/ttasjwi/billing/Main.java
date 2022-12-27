package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // BasicRatePolicy에 더 강력한 사전 조건 추가 -> 계약 위반 -> 리스코프 치환 원칙 위반
        // BasicRatePolicy에 더 완화된 사전 조건 추가 -> 계약 준수 -> 리스코프 치환 원칙 만족
//         Phone regularPhone1 = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
//         regularPhone1.publishBill();

//        // 사후조건 : 서버 측이 져야하는 의무
//        Phone phone = new Phone(
//                            new RateDiscountablePolicy(Money.wons(1000),
//                                new RegularPolicy(Money.wons(100), Duration.ofSeconds(10))));
//        phone.call(new Call(LocalDateTime.of(2017,1,1,10,10),
//                            LocalDateTime.of(2017,1,1,10,11)));
//        Bill bill = phone.publishBill();

        RateDiscountablePolicy policy = new RateDiscountablePolicy(
                Money.wons(1000),
                new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)));
        policy.changeNext(null); // 불변식 위반

    }
}
