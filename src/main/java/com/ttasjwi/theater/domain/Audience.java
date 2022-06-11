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
     * 2. 가방에게 초대장을 전달하여, "알아서" 대가를 차감하게 하고 차감된 액수를 얻어온다.
     * 3. 차감된 요금을 반환.
     */
    public Long buy(Ticket ticket) {
        Long fee = bag.hold(ticket);
        return fee;
    }
}
