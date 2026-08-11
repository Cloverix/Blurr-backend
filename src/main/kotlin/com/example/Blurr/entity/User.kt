package com.example.Blurr.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "email", nullable = false, unique = true, length = 64)
    var email: String,

    @Column(name = "password", nullable = false, length = 64)
    var password: String,
) {
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val wallets: MutableList<Wallet> = mutableListOf();

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val goals: MutableList<Goal> = mutableListOf();

    override fun equals(other: Any?): Boolean {
        if (other == this) return true;
        if (other !is User) return false;
        if (id == 0L || other.id == 0L) return false;
        return other.id == id;
    }

    override fun hashCode(): Int {
        return if (id == 0L) System.identityHashCode(this) else id.hashCode();
    }

    constructor(): this(
        id = 0,
        email = "",
        password = ""
    );
}