import org.springframework.data.jpa.repository.JpaRepository

interface WalletRepository: JpaRepository<Wallet, Long> {
    fun findByNameContaining(name: String): List<Wallet>;
}