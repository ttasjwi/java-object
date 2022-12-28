package com.ttasjwi.movie;

import com.ttasjwi.money.Money;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
