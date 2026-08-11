package com.example.Blurr.exception.handler

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import com.example.Blurr.exception.goal.GoalNotFoundException

@ControllerAdvice
class GoalExceptionHandler {
    fun goalNotFoundHandler(e: GoalNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }
}