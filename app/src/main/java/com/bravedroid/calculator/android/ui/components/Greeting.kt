package com.bravedroid.calculator.android.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bravedroid.calculator.android.ui.theme.CalculatorTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Greeting("from Preview")
    }
}