package com.bravedroid.calculator.android.domain.models

class CalculationBadFormatException(
    message: String,
    cause: Throwable,
) : RuntimeException(message, cause)