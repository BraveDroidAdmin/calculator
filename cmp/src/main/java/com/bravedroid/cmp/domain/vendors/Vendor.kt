package com.bravedroid.cmp.domain.vendors

data class Vendor(
    val vendorType: VendorType,
    val isAccepted: Boolean,
)

enum class VendorType(val vendorCommercialName: String, val vendorDescription: String) {
    GOOGLE_ANALYTICS(
        vendorCommercialName = "Google Analytics",
        vendorDescription = "Google Firebase analytics (to understand your interactions with the app; sends data to Google)",
    ),
    CRASHLYTICS(
        vendorCommercialName = "Crashlytics",
        vendorDescription = "Google Crashlytics (to understand your interactions with the app crashes; sends data to Google)",
    ),
    ;

    companion object {
        fun fromCommercialName(commercialName: String): VendorType = values().first {
            commercialName == it.vendorCommercialName
        }
    }
}
