class TransactionNotFoundException: RuntimeException {
    constructor(message: String = "Transaction not found"): super(message)
}