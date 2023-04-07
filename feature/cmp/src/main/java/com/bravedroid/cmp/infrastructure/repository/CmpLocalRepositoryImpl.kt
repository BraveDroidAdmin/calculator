package com.bravedroid.cmp.infrastructure.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import com.bravedroid.cmp.domain.vendors.Vendor
import com.bravedroid.cmp.domain.vendors.VendorType
import com.bravedroid.cmp.infrastructure.di.CmpInfrastructureModule
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

    override fun getAllVendors(): List<Vendor> =
        VendorType.values().map { vendorType ->
            val isAccepted = sharedPreferences.getBoolean(vendorType.name, false)
            Vendor(vendorType, isAccepted)
        }

    override fun saveVendorsState(vendorList: List<Vendor>) =
        vendorList.forEach { vendor ->
            sharedPreferences.edit(commit = true) {
                putBoolean(vendor.vendorType.name, vendor.isAccepted)
            }
        }
}
