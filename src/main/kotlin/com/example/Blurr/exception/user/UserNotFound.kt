class UserNotFoundException: RuntimeException {
    constructor(message: String = "User not found"): super(message)
}