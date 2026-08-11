package com.example.Blurr.service

import java.time.LocalDateTime
import com.example.Blurr.dto.transaction.TransactionResponseDto
import com.example.Blurr.dto.transaction.TransactionCreateDto
import com.example.Blurr.dto.transaction.TransactionUpdateDto

interface TransactionService {
    fun getById(id: Long): TransactionResponseDto?

    fun getByWalletId(walletId: Long): List<TransactionResponseDto>

    fun getByGoalId(goalId: Long): List<TransactionResponseDto>

    fun getByType(walletId: Long, type: String): List<TransactionResponseDto>

    fun getByCategory(walletId: Long, category: String): List<TransactionResponseDto>

    fun getByCreationTime(walletId: Long, from: LocalDateTime, to: LocalDateTime): List<TransactionResponseDto>

    fun post(dto: TransactionCreateDto): TransactionResponseDto?

    fun update(id: Long, updateDto: TransactionUpdateDto): TransactionResponseDto?

    fun deleteById(id: Long)
}