package com.example.Blurr.service

import com.example.Blurr.dto.user.UserResponseDto
import com.example.Blurr.dto.user.UserRegisterDto
import com.example.Blurr.dto.user.UserUpdateDto

interface UserService {
    fun getById(id: Long): UserResponseDto

    fun register(dto: UserRegisterDto): UserResponseDto

    fun update(id: Long, updateDto: UserUpdateDto): UserResponseDto

    fun deleteById(id: Long)
}