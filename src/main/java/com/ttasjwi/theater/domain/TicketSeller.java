package com.ttasjwi.theater.domain;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /**
     * 관람객에게 티켓을 판매
     */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
