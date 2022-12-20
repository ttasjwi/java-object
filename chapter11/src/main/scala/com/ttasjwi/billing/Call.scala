package com.ttasjwi.billing

import java.time.{Duration, LocalDateTime}

case class Call(val from: LocalDateTime, val to: LocalDateTime) {

  def duration: Duration = Duration.between(from, to)
}
