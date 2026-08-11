package com.example.Blurr.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import com.example.Blurr.repository.WalletRepository
import com.example.Blurr.repository.GoalRepository
import com.example.Blurr.repository.TransactionRepository
import com.example.Blurr.service.TransactionService
import com.example.Blurr.dto.transaction.TransactionResponseDto
import com.example.Blurr.dto.transaction.TransactionCreateDto
import com.example.Blurr.dto.transaction.TransactionUpdateDto
import com.example.Blurr.exception.transaction.TransactionNotFoundException
import com.example.Blurr.exception.wallet.WalletNotFoundException
import com.example.Blurr.exception.goal.GoalNotFoundException
import com.example.Blurr.util.TransactionMapper
import com.example.Blurr.entity.Transaction
import com.example.Blurr.entity.Wallet
import com.example.Blurr.entity.Goal

@Service
@Transactional
class TransactionServiceImpl(
    private val walletRepository: WalletRepository,
    private val goalRepository: GoalRepository,
    private val transactionRepository: TransactionRepository
): TransactionService {
    @Transactional(readOnly = true)
    override fun getById(id: Long): TransactionResponseDto? {
        val transaction = transactionRepository.findById(id).orElseThrow { TransactionNotFoundException() };

        return TransactionMapper.toDto(transaction);
    }

    @Transactional(readOnly = true)
    override fun getByWalletId(walletId: Long): List<TransactionResponseDto> {
        val transactions: List<Transaction> = transactionRepository.findByWalletId(walletId);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByGoalId(goalId: Long): List<TransactionResponseDto> {
        val transactions: List<Transaction> = transactionRepository.findByGoalId(goalId);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByType(walletId: Long, type: String): List<TransactionResponseDto> {
        val transactions: List<Transaction> = transactionRepository.findByWalletIdAndType(walletId, type);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByCategory(walletId: Long, category: String): List<TransactionResponseDto> {
        val transactions: List<Transaction> = transactionRepository.findByWalletIdAndCategory(walletId, category);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByCreationTime(
        walletId: Long,
        from: LocalDateTime,
        to: LocalDateTime
    ): List<TransactionResponseDto> {
        val transactions: List<Transaction> = transactionRepository.findByTimePeriod(walletId, from, to);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun post(dto: TransactionCreateDto): TransactionResponseDto? {
        val wallet: Wallet = walletRepository.findById(dto.walletId).orElseThrow { WalletNotFoundException() };
        val goal: Goal? = dto.goalId?.let {
            goalRepository.findById(it).orElseThrow { GoalNotFoundException() };
        }

        val transaction = Transaction(
            id = 0,
            wallet = wallet,
            goal = goal,
            type = dto.type,
            category = dto.category,
            amount = dto.amount,
            currency = dto.currency,
            description = dto.description
        );

        return TransactionMapper.toDto(transactionRepository.save(transaction));
    }

    override fun update(id: Long, updateDto: TransactionUpdateDto): TransactionResponseDto? {
        val transaction: Transaction = transactionRepository.findById(id).orElseThrow { TransactionNotFoundException() };

        updateDto.type?.let { transaction.type = it };
        updateDto.category?.let { transaction.category = it };
        updateDto.description?.let { transaction.description = it };

        return TransactionMapper.toDto(transactionRepository.save(transaction));
    }

    override fun deleteById(id: Long) {
        transactionRepository.deleteById(id);
    }
}