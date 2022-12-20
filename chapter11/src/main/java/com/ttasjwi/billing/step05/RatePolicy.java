package com.ttasjwi.billing.step05;

import com.ttasjwi.money.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
