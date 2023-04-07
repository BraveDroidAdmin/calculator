package com.bravedroid.calculator.android.domain.models

sealed interface ExpressionPart {
    data class Number(val number: Double): ExpressionPart
    data class Op(val operation: Operation): ExpressionPart
    data class Parentheses(val type: ParenthesesType): ExpressionPart
}
