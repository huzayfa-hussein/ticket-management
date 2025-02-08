package com.hussein.ticketmanagement.dto.error

import com.hussein.ticketmanagement.dto.base.APIStatus

data class APIErrorResponse(
    val status: APIStatus,
    val message: String,
    val exceptionType: String
)
