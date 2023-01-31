package com.bravedroid.cmp.infrastructure.crash_reporting

import com.bravedroid.cmp.domain.crash_reporting.CrashReporter
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class CrashlyticsCrashReporter @Inject constructor() : CrashReporter {

    override fun enableCrashReporting() =
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(true)

    override fun disableCrashReporting() =
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(false)
}
