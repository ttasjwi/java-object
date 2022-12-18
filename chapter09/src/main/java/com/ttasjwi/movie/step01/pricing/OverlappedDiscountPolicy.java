package com.ttasjwi.movie.step01.pricing;

import com.ttasjwi.money.Money;
import com.ttasjwi.movie.step01.DiscountPolicy;
import com.ttasjwi.movie.step01.Screening;

import java.util.ArrayList;
import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy {

    private final List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this. discountPolicies.addAll(List.of(discountPolicies));
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for(DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
