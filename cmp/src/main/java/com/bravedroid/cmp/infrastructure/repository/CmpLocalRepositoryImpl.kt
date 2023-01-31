package com.bravedroid.cmp.infrastructure.repository

import android.content.SharedPreferences
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.infrastructure.di.CmpInfrastructureModule
import androidx.core.content.edit
import javax.inject.Inject

class CmpLocalRepositoryImpl @Inject constructor(
    @CmpInfrastructureModule.CmpSharedPreferences
    private val sharedPreferences: SharedPreferences,
) : CmpLocalRepository {
    override fun isFirstTimeAppLaunched(): Boolean =
        sharedPreferences.getBoolean("isFirstTimeAppLaunched", true)

    override fun saveFirstTimeAppLaunched() {
        sharedPreferences.edit(commit = true) {
            putBoolean("isFirstTimeAppLaunched", false)
        }
    }
}
