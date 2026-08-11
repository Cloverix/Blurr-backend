package com.example.Blurr.exception.handler

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.example.Blurr.exception.wallet.WalletNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class WalletExceptionHandler {
    @ExceptionHandler(WalletNotFoundException::class)
    fun walletNotFoundHandler(e: WalletNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }
}