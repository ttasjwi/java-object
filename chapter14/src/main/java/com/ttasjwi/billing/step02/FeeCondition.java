package com.ttasjwi.billing.step02;

import com.ttasjwi.time.DateTimeInterval;

import java.util.List;

public interface FeeCondition {

    /**
     * 적용 조건을 만족하는 구간들을 나눠서 리스트로 반환
     */
    List<DateTimeInterval> findTimeIntervals(Call call);
}
