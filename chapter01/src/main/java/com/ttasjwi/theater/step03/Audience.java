package com.ttasjwi.theater.step03;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        Long fee = bag.hold(ticket);
        return fee;
    }
}
