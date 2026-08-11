package com.example.Blurr.entity

import jakarta.persistence.*

@Entity
@Table(name = "wallets")
class Wallet (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @Column(name = "name", nullable = false, length = 32)
    var name: String,

    @Column(name = "default_currency", nullable = false, length = 3)
    var defaultCurrency: String
) {
    @OneToMany(mappedBy = "wallet")
    val transactions: MutableList<Transaction> = mutableListOf();

    override fun equals(other: Any?): Boolean {
        if (other == this) return true;
        if (other !is Wallet) return false;
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
        defaultCurrency = ""
    );
}