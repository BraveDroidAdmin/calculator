package com.bravedroid.cmp.domain.startup

import com.bravedroid.cmp.domain.crash_reporting.DisableCrashReporting
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.domain.tracking.DisableTrackingUseCase
import javax.inject.Inject

public class StartupUseCase @Inject constructor(
    private val crashReporterUseCases: DisableCrashReporting,
    private val disableTrackingUseCase: DisableTrackingUseCase,
    private val cmpLocalRepository: CmpLocalRepository,
) {
    operator fun invoke() {
        if (cmpLocalRepository.isFirstTimeAppLaunched()) {
            disableTrackingUseCase()
            crashReporterUseCases()
            cmpLocalRepository.saveFirstTimeAppLaunched()
        }
    }
}
