package com.hussein.ticketmanagement.request

import com.hussein.ticketmanagement.entity.TicketPriority
import com.hussein.ticketmanagement.entity.TicketStatus
import jakarta.validation.constraints.NotBlank

data class CreateTicketRequest(
    @NotBlank(message = "Title must not be blank")
    val title: String,
    val description: String,
    val status: TicketStatus = TicketStatus.OPEN,
    val priority: TicketPriority = TicketPriority.LOW
)
