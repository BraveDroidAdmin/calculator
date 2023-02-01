package com.bravedroid.cmp.domain.vendors

import com.bravedroid.cmp.domain.crash_reporting.CrashReporter
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.domain.tracking.Tracker
import javax.inject.Inject

class SaveVendorsStateUseCase @Inject constructor(
    private val cmpLocalRepository: CmpLocalRepository,
    private val crashReporter: CrashReporter,
    private val tracker: Tracker,
) {
    operator fun invoke(vendorList: List<Vendor>) {
        vendorList.forEach {
            if (it.vendorType == VendorType.CRASHLYTICS) {
                if (it.isAccepted) {
                    crashReporter.enableCrashReporting()
                } else {
                    crashReporter.disableCrashReporting()
                }
            }

            if (it.vendorType == VendorType.GOOGLE_ANALYTICS) {
                if (it.isAccepted) {
                    tracker.enableTracking()
                } else {
                    tracker.disableTracking()
                }
            }
        }
        cmpLocalRepository.saveVendorsState(vendorList)
    }
}
