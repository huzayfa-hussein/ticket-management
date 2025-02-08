package com.hussein.ticketmanagement.controller

import com.hussein.ticketmanagement.dto.TicketDto
import com.hussein.ticketmanagement.dto.base.BaseResponse
import com.hussein.ticketmanagement.entity.TicketPriority
import com.hussein.ticketmanagement.entity.TicketStatus
import com.hussein.ticketmanagement.request.CreateTicketRequest
import com.hussein.ticketmanagement.request.UpdateTicketRequest
import com.hussein.ticketmanagement.service.TicketService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController(private val ticketService: TicketService) {

    @GetMapping("/all")
    fun getAllTickets(): BaseResponse<List<TicketDto>> {
        return ticketService.getAllTickets()
    }

    @GetMapping("")
    fun getTicketById(@RequestParam("id") id: Long): BaseResponse<TicketDto> {
        return ticketService.getTicketById(id)
    }

    @DeleteMapping("/delete")
    fun deleteTicket(@RequestParam("id") id: Long): BaseResponse<String> {
        return ticketService.deleteTicket(id)
    }

    @PostMapping("/create")
    fun createTicket(@Validated @RequestBody createTicketRequest: CreateTicketRequest): BaseResponse<TicketDto> {
        return ticketService.createTicket(createTicketRequest)
    }

    @PatchMapping("/update")
    fun updateTicket(@Validated @RequestBody updateTicketRequest: UpdateTicketRequest): BaseResponse<TicketDto> {
        return ticketService.updateTicket(updateTicketRequest)
    }

    @GetMapping("/get-by-status")
    fun getTicketsByStatus(@RequestParam("status") status: TicketStatus): BaseResponse<List<TicketDto>> {
        return ticketService.getTicketsByStatus(status)
    }

    @GetMapping("/get-by-priority")
    fun getTicketsByPriority(@RequestParam("priority") priority: TicketPriority): BaseResponse<List<TicketDto>> {
        return ticketService.getTicketsByPriority(priority)
    }


    @GetMapping("/filter")
    fun getTicketsByFilter(
        @RequestParam("status") status: TicketStatus,
        @RequestParam("priority") priority: TicketPriority
    ): BaseResponse<List<TicketDto>> {
        return ticketService.getTicketsByStatusAndPriority(status, priority)
    }
}