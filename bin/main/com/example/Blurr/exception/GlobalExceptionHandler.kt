package com.example.Blurr.exception

import com.example.Blurr.exception.goal.GoalNotFoundException
import com.example.Blurr.exception.goal.WrongGoalStatusException
import com.example.Blurr.exception.transaction.TransactionNotFoundException
import com.example.Blurr.exception.user.UserAlreadyRegisteredException
import com.example.Blurr.exception.user.UserNotFoundException
import com.example.Blurr.exception.shared.UnsupportedCurrencyException
import com.example.Blurr.exception.transaction.WrongTransactionTypeException
import com.example.Blurr.exception.wallet.WalletNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFound(e: UserNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(UserAlreadyRegisteredException::class)
    fun handleUserAlreadyRegistered(e: UserAlreadyRegisteredException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }
    
    @ExceptionHandler(WalletNotFoundException::class)
    fun walletNotFoundHandler(e: WalletNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }
    
    @ExceptionHandler(GoalNotFoundException::class)
    fun goalNotFoundHandler(e: GoalNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }
    
    @ExceptionHandler(WrongGoalStatusException::class)
    fun wrongGoalStatusExceptionHandler(e: WrongGoalStatusException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }
    
    @ExceptionHandler(TransactionNotFoundException::class)
    fun transactionNotFoundHandler(e: TransactionNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }
    
    @ExceptionHandler(WrongTransactionTypeException::class)
    fun wrongTransactionTypeExceptionHandler(e: WrongTransactionTypeException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }
    
    
    
    @ExceptionHandler(UnsupportedCurrencyException::class)
    fun unsupportedCurrencyHandler(e: UnsupportedCurrencyException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    } 
}