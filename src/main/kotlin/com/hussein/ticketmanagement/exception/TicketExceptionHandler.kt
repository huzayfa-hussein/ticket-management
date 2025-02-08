package com.hussein.ticketmanagement.exception

import com.hussein.ticketmanagement.dto.base.APIStatus
import com.hussein.ticketmanagement.dto.error.APIErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class TicketExceptionHandler {

    @ExceptionHandler(TicketNotFoundException::class)
    fun handleTicketNotFoundException(exception: TicketNotFoundException): ResponseEntity<APIErrorResponse> {
        val response = APIErrorResponse(APIStatus.ERROR, exception.message, HttpStatus.NOT_FOUND.name)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            response
        )
    }


    @ExceptionHandler(BadRequestException::class)
    fun handelBadRequestException(exception: BadRequestException): ResponseEntity<APIErrorResponse> {
        val response = APIErrorResponse(APIStatus.ERROR, exception.message, HttpStatus.BAD_REQUEST.name)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            response
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(exception: Exception): ResponseEntity<APIErrorResponse> {
        val response = APIErrorResponse(APIStatus.ERROR, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.name)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            response
        )
    }

}