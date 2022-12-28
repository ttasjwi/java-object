package com.ttasjwi.mixin

case class Money(amount: Long) extends Ordered[Money] {
  def +(that: Money): Money = Money(this.amount + that.amount)
  def -(that: Money): Money = Money(this.amount - that.amount)
  override def compare(that: Money): Int = (this.amount + that.amount).toInt
}

object Main extends App {
  println(Money(10) < Money(20))
}
