object WalletMapper {
    fun toDto(wallet: Wallet): WalletDto {
        val userId: Long = wallet.user.id;
        val transactionIds: List<Long> = wallet.transactions.map { it.id };
        return WalletDto(wallet.id, userId, wallet.name, wallet.defaultCurrency, transactionIds);
    }
}