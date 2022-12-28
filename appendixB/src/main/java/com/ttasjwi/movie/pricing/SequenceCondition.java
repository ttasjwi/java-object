package com.ttasjwi.movie.pricing;

import com.ttasjwi.movie.DiscountCondition;
import com.ttasjwi.movie.Screening;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
