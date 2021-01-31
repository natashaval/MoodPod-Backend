package com.natashaval.moodpod.utils

import java.time.LocalDate
import java.time.ZoneId
import java.util.*

object DateUtils {
//  https://www.baeldung.com/java-date-to-localdate-and-localdatetime
  fun Date.convertToLocalDate(): LocalDate {
    return this.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
  }
}