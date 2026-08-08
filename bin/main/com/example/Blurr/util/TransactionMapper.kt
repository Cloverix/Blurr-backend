object TransactionMapper {
    fun toDto(transaction: Transaction): TransactionDto {
        val walletId: Long = transaction.wallet.id;
        val goalId: Long? = transaction.goal?.id;
        return TransactionDto(
            transaction.id,
            walletId,
            goalId,
            transaction.type,
            transaction.category,
            transaction.amount,
            transaction.currency,
            transaction.description,
            transaction.createdAt,
            transaction.updatedAt
        )
    }
}