package com.ttasjwi.movie.step05;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        return screening.reserve(customer, audienceCount);
    }

}
