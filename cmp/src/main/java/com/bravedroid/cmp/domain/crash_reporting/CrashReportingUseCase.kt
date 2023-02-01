package com.bravedroid.cmp.domain.crash_reporting

import javax.inject.Inject

class CrashReportingUseCase @Inject constructor(
    private val crashReporter: CrashReporter,
) {
    internal fun enableCrashReporting() = crashReporter.enableCrashReporting()
    internal fun disableCrashReporting() = crashReporter.disableCrashReporting()
}
