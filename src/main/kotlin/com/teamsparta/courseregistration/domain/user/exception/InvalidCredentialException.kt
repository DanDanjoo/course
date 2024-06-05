package com.teamsparta.courseregistration.domain.user.exception

data class InvalidCredentialException (
    override val message: String? = "The credentials were invalid"
): RuntimeException()
