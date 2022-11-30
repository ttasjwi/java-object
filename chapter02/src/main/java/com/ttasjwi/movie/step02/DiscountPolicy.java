package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
