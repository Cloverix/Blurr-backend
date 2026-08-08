import jakarta.persistence.*
import java.time.LocalDateTime
import java.math.BigDecimal

@Entity
@Table(name = "transactions")
class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    val wallet: Wallet,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    val goal: Goal?,

    @Column(name = "type", nullable = false, length = 16)
    val type: String,

    @Column(name = "category", nullable = false, length = 64)
    val category: String,

    @Column(name = "amount", nullable = false, precision = 14, scale = 2)
    val amount: BigDecimal,

    @Column(name = "currency", nullable = false, length = 3)
    val currency: String,

    @Column(name = "description", length = 128)
    val description: String?,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null
) {
    constructor(): this(
        id = 0,
        wallet = Wallet(),
        goal = null,
        type = "",
        category = "",
        amount = BigDecimal("0"),
        currency = "",
        description = null
    )
}