package com.example.Blurr.service

import com.example.Blurr.constants.Currency
import com.example.Blurr.constants.GoalStatus
import com.example.Blurr.constants.TransactionType
import com.example.Blurr.entity.Goal
import com.example.Blurr.entity.Transaction
import com.example.Blurr.entity.User
import com.example.Blurr.entity.Wallet
import com.example.Blurr.exception.goal.WrongGoalStatusException
import com.example.Blurr.exception.shared.UnsupportedCurrencyException
import com.example.Blurr.exception.transaction.WrongTransactionTypeException
import org.springframework.stereotype.Service

/**
 * Throws exceptions if validation is not passed
 */
@Service
class ValidationService {
    fun validateUser(user: User) {
        
    }
    
    fun validateWallet(wallet: Wallet) {
        val currency = wallet.defaultCurrency
        if (currency !in Currency.entries.map { it.value })
            throw UnsupportedCurrencyException(currency)
    }
    
    fun validateGoal(goal: Goal) {
        val status = goal.status
        if (status !in GoalStatus.entries.map { it.value })
            throw WrongGoalStatusException(status)
        
        val currency = goal.defaultCurrency
        if (currency !in Currency.entries.map { it.value })
            throw UnsupportedCurrencyException(currency)
    }
    
    fun validateTransaction(transaction: Transaction) {
        val type = transaction.type
        if (type !in TransactionType.entries.map { it.value })
            throw WrongTransactionTypeException(type)
        
        val currency = transaction.currency
        if (currency !in Currency.entries.map { it.value })
            throw UnsupportedCurrencyException(currency)
    }
}