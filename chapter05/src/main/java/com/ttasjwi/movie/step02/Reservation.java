package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

public class Reservation {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audiecneCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audiecneCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audiecneCount = audiecneCount;
    }

}
