package com.example.Blurr.util.mapper

import com.example.Blurr.entity.Wallet
import com.example.Blurr.dto.wallet.WalletResponseDto

object WalletMapper {
    fun toDto(wallet: Wallet): WalletResponseDto {
        val userId: Long = wallet.user.id;
        val transactionIds: List<Long> = wallet.transactions.map { it.id };
        return WalletResponseDto(wallet.id, userId, wallet.name, wallet.defaultCurrency, transactionIds);
    }
}