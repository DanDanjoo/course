package com.teamsparta.courseregistration.domain.exception.dto

data class ErrorResponse(
    val errorCode: String,
    val message: String?
)

