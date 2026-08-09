import org.springframework.data.jpa.repository.JpaRepository

interface GoalRepository: JpaRepository<Goal, Long> {
    fun findByNameContaining(name: String): List<Goal>;

    fun findAllByStatus(status: String): List<Goal>;

    fun findAllBySendReminders(sendReminders: Boolean): List<Goal>;
}