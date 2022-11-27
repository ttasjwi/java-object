package com.ttasjwi.theater.step03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    /**
     * 아래 코드는 트레이드 오프 후 step02로 되돌려야한다.
     */
    public void sellTicketTo(Audience audience) {
        Ticket ticket = getTicket();
        Long amount = audience.buy(ticket);
        plusAmount(amount);
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

}
