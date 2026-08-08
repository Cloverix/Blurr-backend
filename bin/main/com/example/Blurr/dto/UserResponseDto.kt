data class UserResponseDto (
    val id: Long,
    val email: String,
    val walletIds: List<Long>,
    val goalIds: List<Long>
)