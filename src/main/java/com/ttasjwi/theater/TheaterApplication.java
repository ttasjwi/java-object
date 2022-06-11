package com.ttasjwi.theater;

import com.ttasjwi.theater.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheaterApplication {

    public static void main(String[] args) {

        // 극장
        List<Ticket> tickets = IntStream.range(0, 100)
                .mapToObj(i -> new Ticket(10000))
                .collect(Collectors.toList());

        TicketOffice ticketOffice = new TicketOffice(0L, tickets);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        // 초대장이 있는 손님
        Invitation invitation = new Invitation(LocalDateTime.of(2022,6,12,14,0,0));
        Bag bag1 = new Bag(invitation, 0);
        Audience audience1 = new Audience(bag1);

        System.out.println("[audience1] [입장 전] 티켓 보유 여부 ? :  "+audience1.getBag().hasTicket());

        theater.enter(audience1);
        System.out.println("[audience1] [인장 후] 티켓 보유 여부 ? : "+audience1.getBag().hasTicket());

        System.out.println("============================================================================");

        // 초대장이 있는 손님
        Bag bag2 = new Bag(30000);
        Audience audience2 = new Audience(bag2);
        System.out.println("[audience2] [입장 전] 티켓 보유여부 ? : "+audience2.getBag().hasTicket());

        theater.enter(audience2);
        System.out.println("[audience2] [입장 후] 티켓 보유여부 ? : "+audience2.getBag().hasTicket());
        System.out.println("[audience2] [입장 후] 보유 금액 ? :  "+audience2.getBag().getAmount());
        System.out.println("Count of Ticket : "+ tickets.size());
    }
}
