package com.ttasjwi.theater.step03;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }


    /**
     * 트레이드 오프 : TicketOffice에게 ticket 판매 책임을 위임 -> TicketOffice가 Audience를 알게 됨
     */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }

}
