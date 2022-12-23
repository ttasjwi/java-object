package com.ttasjwi.billing.step01;

import com.ttasjwi.money.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
