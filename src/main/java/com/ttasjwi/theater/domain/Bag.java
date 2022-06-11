package com.ttasjwi.theater.domain;

public class Bag {

    private Long amount; // 현금 보유량
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

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
            setTicket(ticket);
            Long fee = ticket.getFee();
            minusAmount(fee);
            return fee;
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "amount=" + amount +
                ", invitation=" + invitation +
                ", ticket=" + ticket +
                '}';
    }
}
