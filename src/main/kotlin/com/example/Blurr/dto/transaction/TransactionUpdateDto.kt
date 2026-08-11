package com.example.Blurr.dto.transaction

import java.math.BigDecimal

data class TransactionUpdateDto (
    val type: String?,
    val category: String?,
    val description: String?,
)