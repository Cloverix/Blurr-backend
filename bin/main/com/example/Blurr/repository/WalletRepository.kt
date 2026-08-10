import org.springframework.data.jpa.repository.JpaRepository

interface WalletRepository: JpaRepository<Wallet, Long> {
    fun findByUserId(userId: Long): List<Wallet>

    fun findByUserIdAndNameContaining(userId: Long, name: String): List<Wallet>
}