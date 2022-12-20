package com.ttasjwi.billing

import java.time._

object Main extends App {

  val traitPhone = new Phone(
    List(Call(LocalDateTime.of(2017, 1, 2, 10, 0),
      LocalDateTime.of(2017, 1, 2, 10, 1))),
    new RegularPolicy(Money(100), Duration.ofSeconds(10)) with RateDiscountablePolicy with TaxablePolicy {
      override val discountAmount: Money = Money(100)
      override def taxRate: Double = 0.02
    })
  println(traitPhone.calculateFee)


  val traitPhone2 = new Phone(
    List(Call(LocalDateTime.of(2017, 1, 2, 10, 0), LocalDateTime.of(2017, 1, 2, 10, 1))),
    new RegularPolicy(Money(100), Duration.ofSeconds(10)) with TaxablePolicy with RateDiscountablePolicy {
      override val discountAmount = Money(100)
      override val taxRate = 0.02
    })
  println(traitPhone2.calculateFee)

}
