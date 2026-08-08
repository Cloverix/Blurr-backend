data class WalletDto (
    val id: Long,
    val userId: Long,
    val name: String,
    val defaultCurrency: String,
    val transactionIds: List<Long>
)