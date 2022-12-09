package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = movie.isDiscountable(screening.getWhenScreened(), screening.getSequence());

        Money fee;

        if (discountable) {
            fee = switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT -> movie.calculateAmountDiscountedFee();
                case PERCENT_DISCOUNT -> movie.calculatePercentDiscountedFee();
                case NONE_DISCOUNT -> movie.calculateNoneDiscountedFee();
            };
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
