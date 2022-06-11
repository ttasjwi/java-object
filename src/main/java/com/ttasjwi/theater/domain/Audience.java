package com.ttasjwi.theater.domain;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    /**
     * 티켓 구입
     *
     * 1. 전달받은 티켓이 있을 때 티켓을 받음
     * 2. 자신의 가방을 확인하여 초대장 보유여부를 확인한 뒤 자신의 보유금액을 적절히 차감
     * 3. 차감된 요금을 반환.
     */
    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            Long fee = ticket.getFee();
            bag.minusAmount(fee);
            return fee;
        }
    }
}
