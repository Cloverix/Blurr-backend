interface UserService {
    fun getById(id: Long): UserResponseDto

    fun register(dto: UserRegisterDto): UserResponseDto

    fun update(id: Long, updateDto: UserUpdateDto): UserResponseDto

    fun deleteById(id: Long)
}