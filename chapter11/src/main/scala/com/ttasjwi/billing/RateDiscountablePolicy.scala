package com.ttasjwi.billing

trait RateDiscountablePolicy extends BasicRatePolicy {

  val discountAmount: Money

  override def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    fee - discountAmount
  }
}
