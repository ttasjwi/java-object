package com.ttasjwi.theater.step03;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /**
     * 아래 코드는 트레이드 오프 후 step02로 되돌려야한다.
     */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }

}
