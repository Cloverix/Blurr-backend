import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto (
    val id: Long,
    val walletId: Long,
    val goalId: Long?,
    val type: String,
    val category: String,
    val amount: BigDecimal,
    val currency: String,
    val description: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
)