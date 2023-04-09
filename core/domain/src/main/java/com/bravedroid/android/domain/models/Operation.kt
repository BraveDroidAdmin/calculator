package com.bravedroid.calculator.android.domain.models

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('/'),
    PERCENT('%'),

    ;

    companion object {
        fun fromSymbol(symbol: Char): Operation =
            values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid symbol")

        val OperationSymbols = Operation.values().map { it.symbol }.joinToString("")
    }
}
