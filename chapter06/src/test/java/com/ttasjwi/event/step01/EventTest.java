package com.ttasjwi.event.step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    @DisplayName("질의 메서드 내에 command가 포함되어, 두번의 질의 결과가 다르다")
    public void isSatisfiedTest() {
        //given
        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 9, 10, 30),
                Duration.ofMinutes(30));

        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY,
                                            LocalTime.of(10, 30), Duration.ofMinutes(30));

        //when
        boolean result1 = meeting.isSatisfied(schedule);
        boolean result2 = meeting.isSatisfied(schedule);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }

}
