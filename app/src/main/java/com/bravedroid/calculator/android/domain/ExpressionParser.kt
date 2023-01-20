package com.bravedroid.calculator.android.domain

import com.bravedroid.calculator.android.domain.models.ExpressionPart
import com.bravedroid.calculator.android.domain.models.Operation
import com.bravedroid.calculator.android.domain.models.Operation.Companion.OperationSymbols
import com.bravedroid.calculator.android.domain.models.ParenthesesType

class ExpressionParser(
    private val calculation: String
) {

    fun parse(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()

        var i = 0
        while (i < calculation.length) {
            val curChar = calculation[i]
            when {
                curChar in OperationSymbols -> {
                    result.add(
                        ExpressionPart.Op(Operation.fromSymbol(curChar))
                    )
                }
                curChar.isDigit() -> {
                    i = parseNumber(i, result)
                    continue
                }
                curChar in "()" -> {
                    parseParentheses(curChar, result)
                }
            }
            i++
        }
        return result
    }

    private fun parseNumber(startingIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i = startingIndex
        val numberAsString = buildString {
            while (i < calculation.length && calculation[i] in "0123456789.") {
                append(calculation[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(numberAsString.toDouble()))
        return i
    }

    private fun parseParentheses(curChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when (curChar) {
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Invalid parentheses type")
                }
            )
        )
    }
}