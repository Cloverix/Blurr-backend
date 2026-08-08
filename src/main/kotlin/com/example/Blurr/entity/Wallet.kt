import jakarta.persistence.*

@Entity
@Table(name = "wallets")
class Wallet (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(name = "name", nullable = false, length = 32)
    val name: String,

    @Column(name = "default_currency", nullable = false, length = 3)
    val defaultCurrency: String
) {
    @OneToMany(mappedBy = "wallet")
    val transactions: MutableList<Transaction> = mutableListOf();

    constructor(): this(0, User(), "", "")
}