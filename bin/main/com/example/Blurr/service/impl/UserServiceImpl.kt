import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): UserService {
    @Transactional(readOnly = true)
    override fun getById(id: Long): UserResponseDto { 
        val user: User = userRepository.findById(id).orElseThrow { UserNotFoundException() };
        return UserMapper.toDto(user);
    }

    override fun register(dto: UserRegisterDto): UserResponseDto {
        val existingUser = userRepository.findByEmail(dto.email)
        if (existingUser != null) {
            throw UserAlreadyRegisteredException()
        }

        val encodedPassword = passwordEncoder.encode(dto.password)!!

        val user = User(
            id = 0,
            email = dto.email,
            password = encodedPassword
        )

        return UserMapper.toDto(userRepository.save(user))
    }

    override fun update(id: Long, updateDto: UserUpdateDto): UserResponseDto {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException() }

        updateDto.email?.let { user.email = it }
        updateDto.password?.let { user.password = passwordEncoder.encode(it)!! }

        return UserMapper.toDto(userRepository.save(user))
    }

    override fun deleteById(id: Long) {
        userRepository.deleteById(id);
    }
}