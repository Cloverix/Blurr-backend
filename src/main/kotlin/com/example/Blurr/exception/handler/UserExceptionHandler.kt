package com.example.Blurr.exception.handler

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.example.Blurr.exception.user.UserNotFoundException
import com.example.Blurr.exception.user.UserAlreadyRegisteredException
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFound(e: UserNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyRegisteredException::class)
    fun handleUserAlreadyRegistered(e: UserAlreadyRegisteredException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST);
    }
}