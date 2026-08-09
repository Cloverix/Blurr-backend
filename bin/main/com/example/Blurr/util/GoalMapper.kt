object GoalMapper {
    fun toDto(goal: Goal): GoalResponseDto {
        val userId: Long = goal.user.id;
        val transactionIds: List<Long> = goal.transactions.map { it.id };
        return GoalResponseDto(
            goal.id,
            userId,
            goal.name,
            goal.description,
            goal.status,
            goal.defaultCurrency,
            goal.targetAmount,
            goal.sendReminders,
            goal.singleAmount,
            goal.reminderDays,
            goal.reminderTime,
            goal.lastNotifSentAt,
            transactionIds
        )
    }
}