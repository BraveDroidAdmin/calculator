package com.bravedroid.calculator.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bravedroid.calculator.android.ui.theme.CalculatorTheme

@Composable
fun TestToolsButtonsGroup(onSendHit: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            throw NullPointerException()

        }) {
            Text("Test a Crash !")
        }
        Button(onClick = {
            onSendHit()
        }) {
            Text("Send a Hit !")
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CrashAppButtonPreview() {
    CalculatorTheme {
        TestToolsButtonsGroup {}
    }
}
