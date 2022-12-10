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
            return screening.getMovie().getFee()
                    .minus(calculateDiscountedFee(screening.getMovie()))
                    .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountedFee(Movie movie) {
        return switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT -> calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT -> calculateNoneDiscountedFee(movie);
        };
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return Money.ZERO;
    }

}
