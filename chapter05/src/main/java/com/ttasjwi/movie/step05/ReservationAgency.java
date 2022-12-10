package com.ttasjwi.movie.step05;

import com.ttasjwi.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = checkDiscountable(screening);

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

    private static boolean checkDiscountable(Screening screening) {
        boolean discountable = false;

        for (DiscountCondition condition : screening.getMovie().getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = isSatisfiedByPeriod(screening, condition);
            } else {
                discountable = isSatisfiedBySequence(screening, condition);
            }

            if (discountable) {
                break;
            }
        }
        return discountable;
    }

    private static boolean isSatisfiedByPeriod(Screening screening, DiscountCondition condition) {
        return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private static boolean isSatisfiedBySequence(Screening screening, DiscountCondition condition) {
        return condition.getSequence() == screening.getSequence();
    }
}
