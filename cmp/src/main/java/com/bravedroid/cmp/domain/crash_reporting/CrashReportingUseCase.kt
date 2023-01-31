package com.bravedroid.cmp.domain.crash_reporting

import javax.inject.Inject

class CrashReportingUseCase @Inject constructor(
    private val crashReporter: CrashReporter,
) {
    fun enableCrashReporting() = crashReporter.enableCrashReporting()

    fun disableCrashReporting() = crashReporter.disableCrashReporting()
}
