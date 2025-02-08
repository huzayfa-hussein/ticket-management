package com.hussein.ticketmanagement.dto.base

data class BaseResponse<T>(
    val status: APIStatus,
    val message: String?,
    val data: T? = null
)
