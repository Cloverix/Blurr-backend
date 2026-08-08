import UserResponseDto

object UserMapper {
    fun toDto(user: User): UserResponseDto {
        val walletIds: List<Long> = user.wallets.map { it.id };
        val goalIds: List<Long> = user.goals.map { it.id };
        return UserResponseDto(user.id, user.email, walletIds, goalIds);
    }
}