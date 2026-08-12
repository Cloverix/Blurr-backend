package com.example.Blurr.util.mapper

import com.example.Blurr.entity.Transaction
import com.example.Blurr.dto.transaction.TransactionResponseDto

object TransactionMapper {
    fun toDto(transaction: Transaction): TransactionResponseDto {
        val walletId: Long = transaction.wallet.id;
        val goalId: Long? = transaction.goal?.id;
        return TransactionResponseDto(
            transaction.id,
            walletId,
            goalId,
            transaction.type,
            transaction.category,
            transaction.amount,
            transaction.currency,
            transaction.description,
            transaction.createdAt,
            transaction.updatedAt
        )
    }
}