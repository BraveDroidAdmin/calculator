package com.bravedroid.cmp.domain.tracking

import javax.inject.Inject

class TrackingUseCase @Inject constructor(
    private val tracking: Tracker,
) {
    fun enableTracking() = tracking.enableTracking()

    fun disableTracking() = tracking.disableTracking()
}
