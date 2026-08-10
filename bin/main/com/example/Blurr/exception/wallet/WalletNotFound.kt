class WalletNotFoundException: RuntimeException {
    constructor(message: String = "Wallet not found"): super(message)
}