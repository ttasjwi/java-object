package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.util.List;

public interface RatePolicy {

	Money calculateFee(List<Call> calls) throws EmptyCallException;

}
