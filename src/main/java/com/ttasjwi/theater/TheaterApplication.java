package com.ttasjwi.theater;

import com.ttasjwi.theater.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheaterApplication {

    public static void main(String[] args) {

        // 극장 초기화
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

        System.out.println("[audience1] [입장 전] 가방상태 :  "+bag1);

        theater.enter(audience1);
        System.out.println("[audience1] [입장 후] 가방상태 : "+bag1);

        System.out.println("============================================================================");

        // 초대장이 있는 손님
        Bag bag2 = new Bag(30000);
        Audience audience2 = new Audience(bag2);
        System.out.println("[audience2] [입장 전] 가방상태 : "+bag2);

        theater.enter(audience2);
        System.out.println("[audience2] [입장 후] 가방상태 :  "+bag2);
        System.out.println("Count of Ticket : "+ tickets.size());
    }
}
