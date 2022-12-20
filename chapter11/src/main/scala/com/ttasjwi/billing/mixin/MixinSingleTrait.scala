package com.ttasjwi.billing.mixin

import com.ttasjwi.billing._
import java.time.Duration

class TaxableRegularPolicy(
                            amount: Money,
                            seconds: Duration,
                            val taxRate: Double)
  extends RegularPolicy(amount, seconds)
    with TaxablePolicy

class TaxableNightlyDiscountPolicy(
                                    nightlyAmount: Money,
                                    regularAmount: Money,
                                    seconds: Duration,
                                    val taxRate: Double)
  extends NightlyDiscountPolicy(nightlyAmount, regularAmount, seconds)
    with TaxablePolicy

class RateDiscountableRegularPolicy(
                                     amount: Money,
                                     seconds: Duration,
                                     val discountAmount: Money)
  extends RegularPolicy(amount, seconds)
    with RateDiscountablePolicy

class RateDiscountableNightlyDiscountPolicy(
                                             nightlyAmount: Money,
                                             regularAmount: Money,
                                             seconds: Duration,
                                             val discountAmount: Money)
  extends NightlyDiscountPolicy(nightlyAmount, regularAmount, seconds)
    with RateDiscountablePolicy
