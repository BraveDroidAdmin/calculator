package com.bravedroid.cmp.domain.vendors

import com.bravedroid.cmp.domain.crash_reporting.CrashReporter
import com.bravedroid.cmp.domain.tracking.Tracker
import kotlin.reflect.KClass

data class Vendor(
    val vendorType: VendorType,
    val isAccepted: Boolean,
) {
    fun configureAssociatedSdk(vararg configurableSdk: ConfigurableSdk) {
        val sdkToConfigure = configurableSdk.toList().first { sdk: ConfigurableSdk ->
            sdk.isInstantiableFrom(vendorType.sdkKClass)
        }
        if (isAccepted)
            sdkToConfigure.enableSdk()
        else
            sdkToConfigure.disableSdk()
    }

    private fun <T> T.isInstantiableFrom(kClass: KClass<*>) =
        kClass.isInstance(this)
}

enum class VendorType(
    val vendorCommercialName: String,
    val vendorDescription: String,
    val sdkKClass: KClass<out ConfigurableSdk>,
) {

    GOOGLE_ANALYTICS(
        vendorCommercialName = "Google Analytics",
        vendorDescription = "Google Firebase analytics (to understand your interactions with the app; sends data to Google)",
        Tracker::class,
    ),
    CRASHLYTICS(
        vendorCommercialName = "Crashlytics",
        vendorDescription = "Google Crashlytics (to understand your interactions with the app crashes; sends data to Google)",
        CrashReporter::class,
    ),
    ;

    companion object {
        fun fromCommercialName(commercialName: String): VendorType = values().first {
            commercialName == it.vendorCommercialName
        }
    }
}
