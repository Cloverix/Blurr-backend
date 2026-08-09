import UserResponseDto
import org.hibernate.Hibernate

object UserMapper {
    fun toDto(user: User): UserResponseDto {
        val walletIds: List<Long> = if (Hibernate.isInitialized(user.wallets)) user.wallets.map { it.id }
            else emptyList();
        
        val goalIds: List<Long> = if (Hibernate.isInitialized(user.goals)) user.goals.map { it.id }
            else emptyList();
        
        return UserResponseDto(user.id, user.email, walletIds, goalIds);
    }
}