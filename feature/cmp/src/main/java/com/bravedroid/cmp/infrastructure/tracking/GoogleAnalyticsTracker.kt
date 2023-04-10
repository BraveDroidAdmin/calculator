package com.bravedroid.cmp.infrastructure.tracking

import com.bravedroid.cmp.domain.tracking.Tracker
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class GoogleAnalyticsTracker @Inject constructor() : Tracker {

    override fun enableSdk() =
        Firebase.analytics.setAnalyticsCollectionEnabled(true)

    override fun disableSdk() =
        Firebase.analytics.setAnalyticsCollectionEnabled(false)
}
