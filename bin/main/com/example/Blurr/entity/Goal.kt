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
    var user: User,

    @Column(name = "name", nullable = false, length = 32)
    var name: String,

    @Column(name = "description", length = 128)
    var description: String?,

    @Column(name = "status", nullable = false, length = 16)
    var status: String = "active",

    @Column(name = "default_currency", nullable = false, length = 3)
    var defaultCurrency: String,

    @Column(name = "target_amount", nullable = false, precision = 14, scale = 2)
    var targetAmount: BigDecimal,

    @Column(name = "send_reminders", nullable = false)
    var sendReminders: Boolean,

    @Column(name = "single_amount", precision = 14, scale = 2)
    var singleAmount: BigDecimal?,

    @Column(name = "reminder_days")
    var reminderDays: Int?,

    @Column(name = "reminder_time")
    var reminderTime: LocalTime?,

    @Column(name = "last_notif_sent_at")
    var lastNotifSentAt: LocalDateTime? = null
) {
    @OneToMany(mappedBy = "goal")
    val transactions: MutableList<Transaction> = mutableListOf();

    override fun equals(other: Any?): Boolean {
        if (other == this) return true;
        if (other !is Goal) return false;
        if (id == 0L || other.id == 0L) return false;
        return other.id == id;
    }

    override fun hashCode(): Int {
        return if (id == 0L) System.identityHashCode(this) else id.hashCode();
    }

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
    );
}