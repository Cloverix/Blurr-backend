import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface TransactionRepository: JpaRepository<Transaction, Long> {
    fun findByWalletId(walletId: Long): List<Transaction>

    fun findByGoalId(goalId: Long): List<Transaction>

    fun findByWalletIdAndType(walletId: Long, type: String): List<Transaction>

    fun findByWalletIdAndCategory(walletId: Long, category: String): List<Transaction>

    @Query("SELECT t FROM Transaction WHERE t.wallet.id = :walletId AND t.createdAt BETWEEN :from AND :to")
    fun findByTimePeriod(
        @Param("walletId") walletId: Long,
        @Param("from") from: LocalDateTime,
        @Param("to") to: LocalDateTime
    ): List<Transaction>
}