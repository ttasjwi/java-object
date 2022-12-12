package com.ttasjwi.theater.step03;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        Long amount = bag.hold(ticket);
        return amount;
    }

}
