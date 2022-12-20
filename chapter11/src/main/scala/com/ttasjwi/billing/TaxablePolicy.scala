package com.ttasjwi.billing

trait TaxablePolicy extends BasicRatePolicy {

  def taxRate: Double

  override def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    fee + fee * taxRate
  }
}
