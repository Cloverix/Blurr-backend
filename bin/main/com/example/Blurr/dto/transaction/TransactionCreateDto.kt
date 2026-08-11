package com.example.Blurr.dto.transaction

import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionCreateDto (
    val walletId: Long,
    val goalId: Long?,
    val type: String,
    val category: String,
    val amount: BigDecimal,
    val currency: String,
    val description: String?,
    val createdAt: LocalDateTime
)