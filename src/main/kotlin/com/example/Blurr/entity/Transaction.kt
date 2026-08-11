package com.example.Blurr.entity

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
    var wallet: Wallet,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    var goal: Goal?,

    @Column(name = "type", nullable = false, length = 16)
    var type: String,

    @Column(name = "category", nullable = false, length = 64)
    var category: String,

    @Column(name = "amount", nullable = false, precision = 14, scale = 2)
    var amount: BigDecimal,

    @Column(name = "currency", nullable = false, length = 3)
    var currency: String,

    @Column(name = "description", length = 128)
    var description: String?,

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other == this) return true;
        if (other !is Transaction) return false;
        if (id == 0L || other.id == 0L) return false;
        return other.id == id;
    }

    override fun hashCode(): Int {
        return if (id == 0L) System.identityHashCode(this) else id.hashCode();
    }

    constructor(): this(
        id = 0,
        wallet = Wallet(),
        goal = null,
        type = "",
        category = "",
        amount = BigDecimal("0"),
        currency = "",
        description = null
    );
}