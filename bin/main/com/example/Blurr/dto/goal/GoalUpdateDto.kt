package com.example.Blurr.dto.goal

import java.math.BigDecimal
import java.time.LocalTime

data class GoalUpdateDto (
    val name: String?,
    val description: String?,
    val status: String?,
    val defaultCurrency: String?,
    val sendReminders: Boolean?,
    val singleAmount: BigDecimal?,
    val reminderDays: Int?,
    val reminderTime: LocalTime?
)