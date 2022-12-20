package com.ttasjwi.billing.mixin

import com.ttasjwi.billing._

import java.time.Duration


class RateDiscountableAndTaxableRegularPolicy(
                                               amount: Money,
                                               seconds: Duration,
                                               val discountAmount: Money,
                                               val taxRate: Double)
  extends RegularPolicy(amount, seconds)
    with TaxablePolicy
    with RateDiscountablePolicy

class TaxableAndRateDiscountableRegularPolicy(
                                               amount: Money,
                                               seconds: Duration,
                                               val discountAmount: Money,
                                               val taxRate: Double)
  extends RegularPolicy(amount, seconds)
    with RateDiscountablePolicy
    with TaxablePolicy
