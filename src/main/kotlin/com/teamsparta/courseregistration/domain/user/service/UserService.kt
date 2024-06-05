package com.teamsparta.courseregistration.domain.user.service

import com.teamsparta.courseregistration.domain.user.dto.*

interface UserService {

    fun signUp(request: SignUpRequest): UserResponse

    fun updateUserProfile(userId: Long, response: UpdateUserProfileRequest): UserResponse

    fun login(request: LoginRequest): LoginResponse
}