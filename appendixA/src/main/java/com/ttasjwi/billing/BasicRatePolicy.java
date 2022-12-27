package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {

	@Override
	public Money calculateFee(List<Call> calls) {
		Money result = Money.ZERO;

		for(Call call : calls) {
			result.plus(calculateCallFee(call));
		}
		return result;
	}
	
	protected abstract Money calculateCallFee(Call call);
}
