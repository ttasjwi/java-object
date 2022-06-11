package com.ttasjwi.theater.domain;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            // 초대장을 확인하여 티켓을 건내준다.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 티케 셀러에게 티켓을 얻어야하는데 티켓셀러가 알고있는 티켓 오피스까지 알아야하는 이상한 상황
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
