package com.ttasjwi.theater.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {

    private Long amount; // 판매 금액
    private List<Ticket> tickets = new ArrayList<>(); // 판매할 티켓들


    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }
    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount; // amount가 null이면 어쩌려고?
        this.tickets.addAll(Arrays.asList(tickets));
    }

    /**
     * 리스트의 맨 앞에 있는 티켓부터 꺼내서 제거하고 반환
     */
    public Ticket getTicket() {
        return tickets.remove(0);
    }

    /**
     * 판매 금액 차감
     */
    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    /**
     * 판매 금액 증가
     */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
