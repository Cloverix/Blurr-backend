import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

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
        val transactions = transactionRepository.findByWalletId(walletId);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByGoalId(goalId: Long): List<TransactionResponseDto> {
        val transactions = transactionRepository.findByGoalId(goalId);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByType(walletId: Long, type: String): List<TransactionResponseDto> {
        val transactions = transactionRepository.findByWalletIdAndType(walletId, type);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByCategory(walletId: Long, category: String): List<TransactionResponseDto> {
        val transactions = transactionRepository.findByWalletIdAndCategory(walletId, category);

        return transactions.map { TransactionMapper.toDto(it) };
    }

    override fun getByCreationTime(
        walletId: Long,
        from: LocalDateTime,
        to: LocalDateTime
    ): List<TransactionResponseDto> {
        val transactions = transactionRepository.findByTimePeriod(walletId, from, to);

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
        val transaction = transactionRepository.findById(id).orElseThrow { TransactionNotFoundException() };

        updateDto.type?.let { transaction.type = it };
        updateDto.category?.let { transaction.category = it };
        updateDto.description?.let { transaction.description = it };

        return TransactionMapper.toDto(transactionRepository.save(transaction));
    }

    override fun deleteById(id: Long) {
        transactionRepository.deleteById(id);
    }
}