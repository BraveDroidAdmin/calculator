package com.bravedroid.calculator.android.app

import android.app.Application
import com.bravedroid.cmp.domain.startup.StartupUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CalculatorApp : Application() {
    @Inject
    lateinit var startUpUseCase: StartupUseCase

    override fun onCreate() {
        super.onCreate()
        startUpUseCase()
    }
}
