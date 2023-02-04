package com.bravedroid.cmp.domain.crash_reporting

import javax.inject.Inject

class DisableCrashReporting @Inject constructor(
    private val crashReporter: CrashReporter,
) {
    internal operator fun invoke() = crashReporter.disableSdk()
}
