package edu.self

import java.time.Instant

class DateParser {
  def extractDate(string: String): Long = {
    Instant.parse(string).getEpochSecond
  }
}

object DateParser {
  def apply(): DateParser = new DateParser()
}