package com.ttasjwi.theater.domain;

public class Ticket {

    private Long fee;

    public Ticket(long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
