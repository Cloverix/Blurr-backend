interface GoalService {
    fun getById(id: Long): GoalResponseDto;

    fun getByUserId(userId: Long): List<GoalResponseDto>;

    fun getByNameIncluding(userId: Long, nameIncluding: String): List<GoalResponseDto>;

    fun getByStatus(userId: Long, status: String): List<GoalResponseDto>;

    fun getSendReminders(userId: Long): List<GoalResponseDto>;

    fun post(dto: GoalCreateDto): GoalResponseDto;

    fun update(id: Long, updateDto: GoalUpdateDto): GoalResponseDto;

    fun deleteById(id: Long);
}