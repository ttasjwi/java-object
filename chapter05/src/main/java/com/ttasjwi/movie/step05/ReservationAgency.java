package com.ttasjwi.movie.step05;

import com.ttasjwi.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = screening.getMovie().checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie()
                    .calculateDiscountedFee()
                    .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

}
