package com.example.Blurr.exception.user

class UserNotFoundException: RuntimeException {
    constructor(message: String = "User not found"): super(message)
}