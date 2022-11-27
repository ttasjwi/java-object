package com.ttasjwi.theater.step03;

public class Bag {

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Bag(long amount) {
        this(null, amount);
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            Long fee = ticket.getFee();
            minusAmount(fee);
            setTicket(ticket);
            return fee;
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
