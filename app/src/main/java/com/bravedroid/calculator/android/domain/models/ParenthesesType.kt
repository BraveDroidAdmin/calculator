package com.bravedroid.calculator.android.domain.models

sealed interface ParenthesesType {
    object Opening: ParenthesesType
    object Closing: ParenthesesType
}