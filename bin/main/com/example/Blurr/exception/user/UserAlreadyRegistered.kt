package com.example.Blurr.exception.user

class UserAlreadyRegisteredException: RuntimeException {
    constructor(message: String = "User with this email is already registered"): super(message);
}