package com.bravedroid.calculator.android

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import com.bravedroid.calculator.android.ui.components.TestToolsButtonsGroup
import com.bravedroid.calculator.android.ui.theme.CalculatorTheme
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    TestToolsButtonsGroup {
                        Toast.makeText(this@MainActivity, "send Hit", Toast.LENGTH_SHORT).show()
                        xx()
                        val firebaseAnalytics = Firebase.analytics
                        firebaseAnalytics.logEvent(
                            FirebaseAnalytics.Event.SELECT_ITEM, bundleOf(
                                "CALC_TEST_HIT" to 50.0,
                            )
                        )
                    }
                }
            }
        }
    }

    private fun xx() {

        val now: Instant = Instant.now()

        // convert Instant to ZonedDateTime

        // convert Instant to ZonedDateTime
        val dtf: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss")
        val zonedDateTime: ZonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault())
        System.out.println("DATE: " + dtf.format(zonedDateTime))
    }
}

@Preview
@Composable
fun MainActivityPrev() {
    CalculatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            TestToolsButtonsGroup({})
        }
    }
}
