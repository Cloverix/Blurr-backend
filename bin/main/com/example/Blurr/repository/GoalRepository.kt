import org.springframework.data.jpa.repository.JpaRepository

interface GoalRepository: JpaRepository<Goal, Long> {
    fun findByUserId(userId: Long): List<Goal>

    fun findByUserIdAndNameContaining(userId: Long, name: String): List<Goal>

    fun findByUserIdAndStatus(userId: Long, status: String): List<Goal>

    fun findByUserIdAndSendReminders(userId: Long, sendReminders: Boolean): List<Goal>
}