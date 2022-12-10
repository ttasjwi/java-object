package com.ttasjwi.movie.step05;

import com.ttasjwi.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie()
                .getDiscountConditions()
                .stream()
                .anyMatch(condition -> isDiscountable(condition, screening));
    }

    private boolean isDiscountable(DiscountCondition condition, Screening screening) {
        if (condition.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening, condition);
        }
        return isSatisfiedBySequence(screening, condition);
    }

    private boolean isSatisfiedByPeriod(Screening screening, DiscountCondition condition) {
        return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(Screening screening, DiscountCondition condition) {
        return condition.getSequence() == screening.getSequence();
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

    private static Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private static Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private static Money calculateNoneDiscountedFee(Movie movie) {
        return Money.ZERO;
    }

}
