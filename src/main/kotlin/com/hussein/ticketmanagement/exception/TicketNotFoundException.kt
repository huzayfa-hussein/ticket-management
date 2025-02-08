package com.hussein.ticketmanagement.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
data class TicketNotFoundException(override val message: String) : RuntimeException()