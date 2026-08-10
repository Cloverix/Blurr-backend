import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class GoalServiceImpl(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository
): GoalService {
    @Transactional(readOnly = true)
    override fun getById(id: Long): GoalResponseDto {
        val goal = goalRepository.findById(id).orElseThrow { GoalNotFoundException() };

        return GoalMapper.toDto(goal);
    }

    override fun getByUserId(userId: Long): List<GoalResponseDto> {
        val goals = goalRepository.findByUserId(userId);

        return goals.map { GoalMapper.toDto(it) };
    }

    override fun getByNameIncluding(userId: Long, nameIncluding: String): List<GoalResponseDto> {
        val goals = goalRepository.findByUserIdAndNameContaining(userId, nameIncluding);

        return goals.map { GoalMapper.toDto(it) };
    }

    override fun getByStatus(userId: Long, status: String): List<GoalResponseDto> {
        val goals = goalRepository.findByUserIdAndStatus(userId, status);

        return goals.map { GoalMapper.toDto(it) };
    }

    override fun getSendReminders(userId: Long): List<GoalResponseDto> {
        val goals = goalRepository.findByUserIdAndSendReminders(userId, true);

        return goals.map { GoalMapper.toDto(it) };
    }

    override fun post(dto: GoalCreateDto): GoalResponseDto {
        val user = userRepository.findById(dto.userId).orElseThrow { UserNotFoundException() };
        
        val goal = Goal(
            id = 0,
            user = user,
            name = dto.name,
            description = dto.description,
            defaultCurrency = dto.defaultCurrency,
            targetAmount = dto.targetAmount,
            sendReminders = dto.sendReminders,
            singleAmount = dto.singleAmount,
            reminderDays = dto.reminderDays,
            reminderTime = dto.reminderTime
        );

        return GoalMapper.toDto(goalRepository.save(goal));
    }

    override fun update(id: Long, updateDto: GoalUpdateDto): GoalResponseDto {
        val goal = goalRepository.findById(id).orElseThrow { GoalNotFoundException() };

        updateDto.name?.let { goal.name = it };
        updateDto.description?.let { goal.description = it };
        updateDto.status?.let { goal.status = it };
        updateDto.defaultCurrency?.let { goal.defaultCurrency = it };
        updateDto.sendReminders?.let { goal.sendReminders = it };
        
        goal.singleAmount = updateDto.singleAmount;
        goal.reminderDays = updateDto.reminderDays;
        goal.reminderTime = updateDto.reminderTime;
        
        return GoalMapper.toDto(goalRepository.save(goal));
    }

    override fun deleteById(id: Long) {
        goalRepository.deleteById(id);
    }
}