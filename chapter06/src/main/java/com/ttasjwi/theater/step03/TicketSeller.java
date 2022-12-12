package com.ttasjwi.theater.step03;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void setTicket(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        Long amount = audience.setTicket(ticket);
        ticketOffice.plusAmount(amount);
    }
}
