package com.hussein.ticketmanagement.entity

import com.hussein.ticketmanagement.dto.TicketDto
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import java.util.*

@Entity
@Table(name = "tickets")
data class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @NotBlank(message = "Title must not be blank")
    var title: String = "",
    @NotBlank(message = "Description must not be blank")
    var description: String = "",
    @Enumerated(EnumType.STRING)
    var status: TicketStatus = TicketStatus.OPEN,
    @Enumerated(EnumType.STRING)
    var priority: TicketPriority = TicketPriority.LOW,
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Date = Date(),
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    var updatedAt: Date = Date(),
) {
    fun convertToDto(): TicketDto =
        TicketDto(
            id = id,
            title = title,
            description = description,
            status = status,
            priority = priority,
            createdAt = createdAt.toString(),
            updatedAt = updatedAt.toString()
        )
}