package com.example.Blurr.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.example.Blurr.repository.UserRepository
import com.example.Blurr.repository.WalletRepository
import com.example.Blurr.service.WalletService
import com.example.Blurr.dto.wallet.WalletResponseDto
import com.example.Blurr.dto.wallet.WalletCreateDto
import com.example.Blurr.dto.wallet.WalletUpdateDto
import com.example.Blurr.exception.wallet.WalletNotFoundException
import com.example.Blurr.exception.user.UserNotFoundException
import com.example.Blurr.util.WalletMapper
import com.example.Blurr.entity.Wallet

@Service
@Transactional
class WalletServiceImpl(
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository
): WalletService {
    @Transactional(readOnly = true)
    override fun getById(id: Long): WalletResponseDto {
        val wallet = walletRepository.findById(id).orElseThrow { WalletNotFoundException() };

        return WalletMapper.toDto(wallet);
    }

    @Transactional(readOnly = true)
    override fun getByUserId(userId: Long): List<WalletResponseDto> {
        val wallets: List<Wallet> = walletRepository.findByUserId(userId);

        return wallets.map { WalletMapper.toDto(it) };
    }

    @Transactional(readOnly = true)
    override fun getByNameIncluding(userId: Long, nameIncluding: String): List<WalletResponseDto> {
        val wallets: List<Wallet> = walletRepository.findByUserIdAndNameContaining(userId, nameIncluding);

        return wallets.map { WalletMapper.toDto(it) };
    }

    override fun post(dto: WalletCreateDto): WalletResponseDto {
        val user = userRepository.findById(dto.userId).orElseThrow { UserNotFoundException() };
        
        val wallet = Wallet(
            id = 0,
            user = user,
            name = dto.name,
            defaultCurrency = dto.defaultCurrency
        );

        return WalletMapper.toDto(walletRepository.save(wallet));
    }

    override fun update(id: Long, updateDto: WalletUpdateDto): WalletResponseDto {
        val wallet: Wallet = walletRepository.findById(id).orElseThrow { WalletNotFoundException() };

        updateDto.name?.let { wallet.name = it };
        updateDto.defaultCurrency?.let { wallet.defaultCurrency = it };

        return WalletMapper.toDto(walletRepository.save(wallet));
    }

    override fun deleteById(id: Long) {
        walletRepository.deleteById(id);
    }
}