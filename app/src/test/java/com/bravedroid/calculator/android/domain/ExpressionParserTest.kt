package com.bravedroid.calculator.android.domain

import com.bravedroid.calculator.android.domain.models.ExpressionPart
import com.bravedroid.calculator.android.domain.models.Operation
import com.bravedroid.calculator.android.domain.models.Operation.ADD
import com.bravedroid.calculator.android.domain.models.Operation.SUBTRACT
import com.bravedroid.calculator.android.domain.models.ParenthesesType
import com.bravedroid.calculator.android.domain.models.ParenthesesType.Closing
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {
        // 1. GIVEN
        parser = ExpressionParser("3+5-3x4/3")

        // 2. DO SOMETHING WITH WHAT'S GIVEN
        val actual = parser.parse()

        // 3. ASSERT EXPECTED == ACTUAL
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(3.0),
        )
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with parentheses is properly parsed`() {
        parser = ExpressionParser("4-(4x5)")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing),
        )
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with only numbers is properly parsed`() {
        parser = ExpressionParser("4.33")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(4.33),
        )
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with mixed numbers and parenthesis is properly parsed`() {
        parser = ExpressionParser("4.33)")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(4.33),
            ExpressionPart.Parentheses(Closing),
        )
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with mixed operations and parenthesis is properly parsed`() {
        parser = ExpressionParser("+-)")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Op(ADD),
            ExpressionPart.Op(SUBTRACT),
            ExpressionPart.Parentheses(Closing),
        )
        assertThat(expected).isEqualTo(actual)
    }

    @Test(expected = NumberFormatException::class)
    fun `Expression with more than one dot should not be accepted`() {
        parser = ExpressionParser("1.1.1")
        parser.parse()
    }
}