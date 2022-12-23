package com.ttasjwi.billing.step02;

import com.ttasjwi.time.DateTimeInterval;

import java.util.Arrays;
import java.util.List;

public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Arrays.asList(call.getInterval());
    }
}
