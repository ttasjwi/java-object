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
            Money discountAmount = switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT -> movie.getDiscountAmount();
                case PERCENT_DISCOUNT -> movie.getFee().times(movie.getDiscountPercent());
                case NONE_DISCOUNT -> Money.ZERO;
            };

            fee = movie.getFee().minus(discountAmount);

        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
