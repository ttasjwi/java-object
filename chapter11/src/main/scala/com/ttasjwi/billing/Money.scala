package com.ttasjwi.billing

case class Money(amount: Long) {

  def +(that: Money) = Money(this.amount + that.amount)

  def -(that: Money) = Money(this.amount - that.amount)

  def *(times: Double) = Money((this.amount.toDouble * times).toLong)
}
