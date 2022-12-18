package com.ttasjwi.movie.step03;

import com.ttasjwi.money.Money;

public class Reservation {

    private Customer customer;
    private com.ttasjwi.movie.step03.Screening Screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, com.ttasjwi.movie.step03.Screening Screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
