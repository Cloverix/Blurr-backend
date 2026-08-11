package com.example.Blurr.exception.goal

class GoalNotFoundException: RuntimeException {
    constructor(message: String = "Goal not found"): super(message)
}