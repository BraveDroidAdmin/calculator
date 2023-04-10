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
        vendorList.forEach { vendor ->
            vendor.configureAssociatedSdk(tracker, crashReporter)
        }
        cmpLocalRepository.saveVendorsState(vendorList)
    }
}
