package com.example.Blurr.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import com.example.Blurr.service.TransactionService
import com.example.Blurr.dto.transaction.TransactionResponseDto
import com.example.Blurr.dto.transaction.TransactionCreateDto
import com.example.Blurr.dto.transaction.TransactionUpdateDto

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TransactionResponseDto> {
        return ResponseEntity.ok(transactionService.getById(id));
    }

    @GetMapping("/byWalletId")
    fun getByWalletId(
        @RequestParam(name = "walletId") walletId: Long
    ): ResponseEntity<List<TransactionResponseDto>> {
        return ResponseEntity.ok(transactionService.getByWalletId(walletId));
    }

    @GetMapping("/byGoalId")
    fun getByGoalId(
        @RequestParam(name = "goalId") goalId: Long
    ): ResponseEntity<List<TransactionResponseDto>> {
        return ResponseEntity.ok(transactionService.getByGoalId(goalId));
    }

    //For wallet statistics
    @GetMapping("/byType")
    fun getByType(
        @RequestParam(name = "walletId") walletId: Long,
        @RequestParam(name = "type") type: String
    ): ResponseEntity<List<TransactionResponseDto>> {
        return ResponseEntity.ok(transactionService.getByType(walletId, type));
    }

    //For wallet statistics
    @GetMapping("/byCategory")
    fun getByCategory(
        @RequestParam(name = "walletId") walletId: Long,
        @RequestParam(name = "category") category: String
    ): ResponseEntity<List<TransactionResponseDto>> {
        return ResponseEntity.ok(transactionService.getByCategory(walletId, category));
    }

    @GetMapping("/byCreationTime")
    fun getByCreationTime(
        @RequestParam(name = "walletId") walletId: Long,
        @RequestParam(name = "from") from: LocalDateTime,
        @RequestParam(name = "to") to: LocalDateTime
    ): ResponseEntity<List<TransactionResponseDto>> {
        return ResponseEntity.ok(transactionService.getByCreationTime(walletId, from, to));
    }

    @PostMapping
    fun post(@RequestBody dto: TransactionCreateDto): ResponseEntity<TransactionResponseDto> {
        return ResponseEntity(transactionService.post(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: TransactionUpdateDto
    ): ResponseEntity<TransactionResponseDto> {
        return ResponseEntity.ok(transactionService.update(id, updateDto));
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(transactionService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}