package com.ttasjwi.movie.step03.pricing;

import com.ttasjwi.movie.step03.DiscountCondition;
import com.ttasjwi.movie.step03.Screening;

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
