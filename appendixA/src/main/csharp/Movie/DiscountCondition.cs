using System;

namespace MovieReservation
{
    public interface DiscountCondition
    {
        bool IsSatisfiedBy(Screening screening);
    }
}