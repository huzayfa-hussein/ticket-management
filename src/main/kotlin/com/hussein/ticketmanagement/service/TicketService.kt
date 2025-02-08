package com.hussein.ticketmanagement.service

import com.hussein.ticketmanagement.dto.TicketDto
import com.hussein.ticketmanagement.dto.base.APIStatus
import com.hussein.ticketmanagement.dto.base.BaseResponse
import com.hussein.ticketmanagement.entity.Ticket
import com.hussein.ticketmanagement.entity.TicketPriority
import com.hussein.ticketmanagement.entity.TicketStatus
import com.hussein.ticketmanagement.exception.BadRequestException
import com.hussein.ticketmanagement.exception.TicketNotFoundException
import com.hussein.ticketmanagement.repository.TicketRepository
import com.hussein.ticketmanagement.request.CreateTicketRequest
import com.hussein.ticketmanagement.request.UpdateTicketRequest
import org.springframework.stereotype.Service

@Service
class TicketService(private val ticketRepository: TicketRepository) {


    fun getAllTickets(): BaseResponse<List<TicketDto>> {
        val tickets = ticketRepository.findAll()
        if (tickets.isEmpty()) {
            throw TicketNotFoundException("No Tickets Found")
        }
        val ticketListDto = tickets.map { it.convertToDto() }
        return BaseResponse(status = APIStatus.SUCCESS, message = "Tickets Fetched Successfully", data = ticketListDto)
    }

    fun getTicketById(id: Long): BaseResponse<TicketDto> {
        val ticket = ticketRepository.findById(id)
        if (!ticket.isPresent) {
            throw TicketNotFoundException("Ticket with id $id Not Found")
        }
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Ticket Fetched Successfully",
            data = ticket.get().convertToDto()
        )
    }

    fun getTicketsByStatus(status: TicketStatus): BaseResponse<List<TicketDto>> {
        val tickets = ticketRepository.findTicketsByStatus(status)
        if (tickets.isEmpty()) {
            throw TicketNotFoundException("No Tickets Found")
        }
        val ticketListDto = tickets.map { it.convertToDto() }
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Tickets with status: $status are Fetched Successfully",
            data = ticketListDto
        )
    }

    fun getTicketsByPriority(priority: TicketPriority): BaseResponse<List<TicketDto>> {
        val tickets = ticketRepository.findTicketsByPriority(priority)
        if (tickets.isEmpty()) {
            throw TicketNotFoundException("No Tickets Found")
        }
        val ticketListDto = tickets.map { it.convertToDto() }
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Tickets with priority: $priority are Fetched Successfully",
            data = ticketListDto
        )
    }

    fun getTicketsByStatusAndPriority(status: TicketStatus, priority: TicketPriority): BaseResponse<List<TicketDto>> {
        val tickets = ticketRepository.findTicketsByStatusAndPriority(status, priority)
        if (tickets.isEmpty()) {
            throw TicketNotFoundException("No Tickets Found")
        }
        val ticketListDto = tickets.map { it.convertToDto() }
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Tickets with status: $status and priority: $priority are Fetched Successfully",
            data = ticketListDto
        )
    }

    fun createTicket(createTicketRequest: CreateTicketRequest): BaseResponse<TicketDto> {
        val isRequestValid = createTicketRequest.description.isNotEmpty()
        if (isRequestValid.not()) {
            throw BadRequestException("Description is required")
        }
        val ticket = Ticket()
        ticket.title = createTicketRequest.title
        ticket.description = createTicketRequest.description
        ticket.status = createTicketRequest.status
        ticket.priority = createTicketRequest.priority
        ticketRepository.save(ticket)
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Ticket Created Successfully",
            data = ticket.convertToDto()
        )
    }

    fun updateTicket(updateTicketRequest: UpdateTicketRequest): BaseResponse<TicketDto> {
        val ticket = ticketRepository.findById(updateTicketRequest.id)
        if (ticket.isPresent.not()) {
            throw TicketNotFoundException("Ticket with id ${updateTicketRequest.id} Not Found")
        }
        val t = ticket.get()
        for (prop in UpdateTicketRequest::class.java.declaredFields) {
            prop.isAccessible = true
            if (prop.get(updateTicketRequest) != null) {
                prop.set(t, prop.get(updateTicketRequest))
            }
        }
        ticketRepository.save(t)
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Ticket Updated Successfully",
            data = t.convertToDto()
        )
    }

    fun deleteTicket(id: Long): BaseResponse<String> {
        val ticket = ticketRepository.findById(id)
        if (ticket.isPresent.not()) {
            throw TicketNotFoundException("Ticket with id $id Not Found")
        }
        ticketRepository.delete(ticket.get())
        return BaseResponse(
            status = APIStatus.SUCCESS,
            message = "Ticket with id $id Deleted Successfully",
            data = "Deleted"
        )
    }
}