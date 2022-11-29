package com.ttasjwi.movie.step01.pricing;

import com.ttasjwi.movie.step01.DiscountCondition;
import com.ttasjwi.movie.step01.Screening;

/**
 * 순번 할인조건
 */

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
