package com.bravedroid.cmp.domain.startup

import com.bravedroid.cmp.domain.crash_reporting.CrashReportingUseCase
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.domain.tracking.TrackingUseCase
import javax.inject.Inject

public class StartupUseCase @Inject constructor(
    private val crashReporterUseCases: CrashReportingUseCase,
    private val trackingUseCase: TrackingUseCase,
    private val cmpLocalRepository: CmpLocalRepository,
) {
    operator fun invoke() {
        if (cmpLocalRepository.isFirstTimeAppLaunched()) {
            trackingUseCase.disableTracking()
            crashReporterUseCases.disableCrashReporting()
            cmpLocalRepository.saveFirstTimeAppLaunched()
        }
    }
}
