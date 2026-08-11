package com.example.Blurr.dto.wallet

data class WalletCreateDto (
    val userId: Long,
    val name: String,
    val defaultCurrency: String
)