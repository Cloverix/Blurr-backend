package com.example.Blurr.exception.goal

class WrongGoalStatusException: RuntimeException {
    constructor(status: String): super("Goal status $status is wrong")
}