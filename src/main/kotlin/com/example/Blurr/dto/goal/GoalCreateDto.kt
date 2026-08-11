package com.example.Blurr.dto.goal

import java.math.BigDecimal
import java.time.LocalTime

data class GoalCreateDto (
    val userId: Long,
    val name: String,
    val description: String?,
    val defaultCurrency: String,
    val targetAmount: BigDecimal,
    val sendReminders: Boolean,
    val singleAmount: BigDecimal?,
    val reminderDays: Int?,
    val reminderTime: LocalTime?    
)