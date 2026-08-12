package com.example.Blurr.exception.transaction

class WrongTransactionTypeException: RuntimeException {
    constructor(type: String): super("Transaction type $type is not supported")
}