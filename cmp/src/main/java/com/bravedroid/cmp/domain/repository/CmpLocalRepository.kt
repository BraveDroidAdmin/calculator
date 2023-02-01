package com.bravedroid.cmp.domain.repository

import com.bravedroid.cmp.domain.vendors.Vendor

interface CmpLocalRepository {
    fun isFirstTimeAppLaunched(): Boolean
    fun saveFirstTimeAppLaunched()
    fun getAllVendors(): List<Vendor>
    fun saveVendorsState(vendorList: List<Vendor>)
}
