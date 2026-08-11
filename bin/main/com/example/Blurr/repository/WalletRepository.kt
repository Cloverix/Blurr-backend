package com.example.Blurr.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.example.Blurr.entity.Wallet

interface WalletRepository: JpaRepository<Wallet, Long> {
    fun findByUserId(userId: Long): List<Wallet>

    fun findByUserIdAndNameContaining(userId: Long, name: String): List<Wallet>
}