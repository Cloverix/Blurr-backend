package com.example.Blurr.exception.transaction

class TransactionNotFoundException: RuntimeException {
    constructor(message: String = "Transaction not found"): super(message)
}