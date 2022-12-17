package com.ttasjwi;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.Customer;
import com.ttasjwi.movie.Movie;
import com.ttasjwi.movie.Screening;
import com.ttasjwi.movie.pricing.AmountDiscountPolicy;
import com.ttasjwi.movie.pricing.PeriodCondition;
import com.ttasjwi.movie.pricing.SequenceCondition;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Client {

    public static void main(String[] args) {
        /**
         * 사용과 생성의 책임 분리
         * 1) 사용 : 객체
         * 2) 생성 : 클라이언트 측에서 담당
         *
         * -> 의존성을 특정 컨텍스트에 묶지 않고 추상화에 의존하게 하여 설계를 유연하게 함
         */
        Movie movie = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(21, 0))));

        Screening screening = new Screening(movie, 10, LocalDateTime.of(2022, 12, 19, 10, 0));
        Customer customer = new Customer("땃쥐", "ttasjwi");

        screening.reserve(customer, 3);
    }
}
