package com.ttasjwi.movie.step02;

import com.ttasjwi.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;

        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = condition.isDiscountable(condition.getDayOfWeek(), screening.getWhenScreened().toLocalTime());
            } else {
                discountable = condition.isDiscountable(screening.getSequence());
            }

            if (discountable) {
                break;
            }
        }

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
