object TransactionMapper {
    fun toDto(transaction: Transaction): TransactionResponseDto {
        val walletId: Long = transaction.wallet.id;
        val goalId: Long? = transaction.goal?.id;
        return TransactionResponseDto(
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