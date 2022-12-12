package com.ttasjwi.theater.step02;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long setTicket(Ticket ticket) {
        Long amount = bag.setTicket(ticket);
        return amount;
    }

}
