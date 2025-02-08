package com.hussein.ticketmanagement.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd"

fun Date.formatDate(format: String = DEFAULT_DATE_FORMAT): String {

    val formatter = DateTimeFormatter.ofPattern(format)

    return LocalDate.parse(formatter.format(this.toInstant())).toString()
}