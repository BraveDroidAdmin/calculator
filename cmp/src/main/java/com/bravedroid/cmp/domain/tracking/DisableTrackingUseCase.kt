package com.bravedroid.cmp.domain.tracking

import javax.inject.Inject

class DisableTrackingUseCase @Inject constructor(
    private val tracking: Tracker,
) {
    internal operator fun invoke() = tracking.disableSdk()
}
