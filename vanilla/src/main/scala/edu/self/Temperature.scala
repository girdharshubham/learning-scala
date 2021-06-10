package edu.self

import java.time.ZonedDateTime
import java.util.UUID

case class Temperature(
                        deviceId: UUID,
                        temperature: Double,
                        timestamp: ZonedDateTime
                      )
