package com.ttasjwi.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateTimeInterval {

    private LocalDateTime from;
    private LocalDateTime to;

    public static DateTimeInterval of(LocalDateTime from, LocalDateTime to) {
        return new DateTimeInterval(from, to);
    }

    public static DateTimeInterval toMidnight(LocalDateTime from) {
        return new DateTimeInterval(
                from,
                LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999_999_999)));
    }

    public static DateTimeInterval fromMidnight(LocalDateTime to) {
        return new DateTimeInterval(
                LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)),
                to);
    }

    public static DateTimeInterval during(LocalDate date) {
        return new DateTimeInterval(
                LocalDateTime.of(date, LocalTime.of(0, 0)),
                LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999_999_999))
        );
    }

    private DateTimeInterval(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    /**
     * 일자별로 분할하여, 리스트로 반환
     */
    public List<DateTimeInterval> splitByDay() {
        return (days() > 0)
                ? splitByDay(days())
                : Arrays.asList(this);
    }

    /**
     * 시작 시점부터, 종료시점까지의 날짜 차이
     */
    private long days() {
        return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay())
                .toDays();
    }

    /**
     * 날짜 분할
     */
    private List<DateTimeInterval> splitByDay(long days) {
        List<DateTimeInterval> result = new ArrayList<>();

        addFirstDay(result);
        addMiddleDays(result, days);
        addLastDay(result);

        return result;
    }

    /**
     * 첫날 분할
     */
    private void addFirstDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.toMidnight(from));
    }

    /**
     * 첫날, 마지막 날 사이의 날들 분할
     */
    private void addMiddleDays(List<DateTimeInterval> result, long days) {
        for (int loop = 1; loop < days; loop++) {
            result.add(DateTimeInterval.during(from.toLocalDate().plusDays(loop)));
        }
    }

    /**
     * 마지막 날 분할
     */
    private void addLastDay(List<DateTimeInterval> result) {
        result.add(DateTimeInterval.fromMidnight(to));
    }

    public Duration duration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

}
