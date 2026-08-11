package com.example.Blurr.dto.wallet

data class WalletResponseDto (
    val id: Long,
    val userId: Long,
    val name: String,
    val defaultCurrency: String,
    val transactionIds: List<Long>
)