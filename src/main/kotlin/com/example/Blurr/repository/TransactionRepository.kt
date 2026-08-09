import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Long> {
    fun findAllByType(type: String): List<Transaction>;
}