interface WalletService {
    fun getById(id: Long): WalletResponseDto

    fun getByUserId(userId: Long): List<WalletResponseDto>

    fun getByNameIncluding(userId: Long, nameIncluding: String): List<WalletResponseDto>

    fun post(dto: WalletCreateDto): WalletResponseDto

    fun update(id: Long, updateDto: WalletUpdateDto): WalletResponseDto

    fun deleteById(id: Long)
}