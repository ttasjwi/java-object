package com.ttasjwi.billing.step02;

import com.ttasjwi.money.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
