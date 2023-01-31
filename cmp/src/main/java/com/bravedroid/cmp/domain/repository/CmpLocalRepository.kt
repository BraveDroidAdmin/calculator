package com.bravedroid.cmp.domain.repository

interface CmpLocalRepository {
    fun isFirstTimeAppLaunched(): Boolean
    fun saveFirstTimeAppLaunched()
}
