package com.ttasjwi.movie.step03;

import com.ttasjwi.money.Money;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Reservation reserve(Customer customer, int audienceCount) {
        Money fee = calculateFee(audienceCount);
        return new Reservation(customer, this, fee, audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
