package com.example.Blurr.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.example.Blurr.entity.User

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}