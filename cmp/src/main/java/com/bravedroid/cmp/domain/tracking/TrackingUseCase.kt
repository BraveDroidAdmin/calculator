package com.bravedroid.cmp.domain.tracking

import javax.inject.Inject

class TrackingUseCase @Inject constructor(
    private val tracking: Tracker,
) {
    internal fun enableTracking() = tracking.enableTracking()
    internal fun disableTracking() = tracking.disableTracking()
}
