import jakarta.persistence.*
import java.time.LocalTime
import java.time.LocalDateTime
import java.math.BigDecimal

@Entity
@Table(name = "goals")
class Goal (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(name = "name", nullable = false, length = 32)
    val name: String,

    @Column(name = "description", length = 128)
    val description: String?,

    @Column(name = "status", nullable = false, length = 16)
    val status: String = "active",

    @Column(name = "default_currency", nullable = false, length = 3)
    val defaultCurrency: String,

    @Column(name = "target_amount", nullable = false, precision = 14, scale = 2)
    val targetAmount: BigDecimal,

    @Column(name = "send_reminders", nullable = false)
    val sendReminders: Boolean,

    @Column(name = "single_amount", precision = 14, scale = 2)
    val singleAmount: BigDecimal?,

    @Column(name = "reminder_days")
    val reminderDays: Int?,

    @Column(name = "reminder_time")
    val reminderTime: LocalTime?,

    @Column(name = "last_notif_sent_at")
    val lastNotifSentAt: LocalDateTime? = null
) {
    @OneToMany(mappedBy = "goal")
    val transactions: MutableList<Transaction> = mutableListOf();

    constructor(): this(
        id = 0,
        user = User(),
        name = "",
        description = null,
        defaultCurrency = "",
        targetAmount = BigDecimal("0"),
        sendReminders = false,
        singleAmount = null,
        reminderDays = null,
        reminderTime = null,
        lastNotifSentAt = null
    )
}