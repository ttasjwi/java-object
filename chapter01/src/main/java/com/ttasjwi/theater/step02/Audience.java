package com.ttasjwi.theater.step02;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            Long fee = ticket.getFee();
            bag.minusAmount(fee);
            bag.setTicket(ticket);
            return fee;
        }
    }
}
