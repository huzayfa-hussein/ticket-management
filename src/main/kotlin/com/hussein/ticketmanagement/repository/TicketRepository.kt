package com.hussein.ticketmanagement.repository

import com.hussein.ticketmanagement.entity.Ticket
import com.hussein.ticketmanagement.entity.TicketPriority
import com.hussein.ticketmanagement.entity.TicketStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, Long> {

    fun findTicketsByStatus(status: TicketStatus): List<Ticket>

    fun findTicketsByPriority(priority: TicketPriority): List<Ticket>

    fun findTicketsByStatusAndPriority(status: TicketStatus, priority: TicketPriority): List<Ticket>
}