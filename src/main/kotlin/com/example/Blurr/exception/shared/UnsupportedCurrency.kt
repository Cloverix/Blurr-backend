package com.example.Blurr.exception.shared

class UnsupportedCurrencyException: RuntimeException {
    constructor(currencyName: String): super("Currency $currencyName is not supported")
}