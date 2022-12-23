package com.ttasjwi.billing.step02;

import com.ttasjwi.time.DateTimeInterval;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DurationFeeCondition implements FeeCondition {

    private Duration from; // 조건에 맞기 시작하는 경과 시간
    private Duration to; // 조건이 끝나는 경과 시간

    public DurationFeeCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if (call.getInterval().duration().compareTo(from) < 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(DateTimeInterval.of(
                call.getInterval().getFrom().plus(from),
                call.getInterval().duration().compareTo(to) > 0 // 통화의 전체시간이 to 의 범위를 벗어났을 경우
                        ? call.getInterval().getFrom().plus(to)
                        : call.getInterval().getTo()));
    }
}
