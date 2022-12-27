package com.ttasjwi.billing;

import com.ttasjwi.money.Money;

import java.util.List;

public abstract class BasicRatePolicy implements RatePolicy {

	@Override
	public Money calculateFee(List<Call> calls) {
		if (calls == null || calls.isEmpty()) {
			throw new NoneElementException(); // 클라이언트 입장에서 예상하지 못 한 예외 -> 가변성 규칙 위반 -> 리스코프 치환 원칙 위반
		}

		Money result = Money.ZERO;

		for(Call call : calls) {
			result.plus(calculateCallFee(call));
		}

		// 사후조건
		assert result.isGreaterThanOrEqual(Money.ZERO);

		return result;
	}
	
	protected abstract Money calculateCallFee(Call call);
}
