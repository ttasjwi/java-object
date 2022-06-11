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

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket()  {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public Long getAmount() {
        return amount;
    }
}
