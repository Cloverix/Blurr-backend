package com.example.Blurr.exception.handler

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.example.Blurr.exception.transaction.TransactionNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class TransactionExceptionHandler {
    @ExceptionHandler(TransactionNotFoundException::class)
    fun transactionNotFoundHandler(e: TransactionNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }
}