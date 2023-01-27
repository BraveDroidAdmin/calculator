package com.bravedroid.calculator.android.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CalculatorApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
