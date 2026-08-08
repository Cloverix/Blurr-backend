import jakarta.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "email", nullable = false, unique = true, length = 64)
    val email: String,

    @Column(name = "password", nullable = false, length = 64)
    val password: String,
) {
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val wallets: MutableList<Wallet> = mutableListOf();

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val goals: MutableList<Goal> = mutableListOf();

    constructor(): this(0, "", "");
}