package com.hussein.ticketmanagement.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.hussein.ticketmanagement.entity.TicketPriority
import com.hussein.ticketmanagement.entity.TicketStatus

data class TicketDto(

    val id: Long,
    val title: String,
    val description: String,
    val status: TicketStatus,
    val priority: TicketPriority,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("updated_at")
    val updatedAt: String
)
