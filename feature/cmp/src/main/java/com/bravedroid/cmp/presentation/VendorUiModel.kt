package com.bravedroid.cmp.presentation

import com.bravedroid.cmp.domain.vendors.Vendor
import com.bravedroid.cmp.domain.vendors.VendorType

data class VendorUiModel(
    val vendorName: String,
    val vendorDescription: String,
    var isAccepted: Boolean,
) {
    companion object {
        fun Vendor.toUiModel(): VendorUiModel =
            VendorUiModel(
                vendorName = vendorType.vendorCommercialName,
                vendorDescription = vendorType.vendorDescription,
                isAccepted = isAccepted
            )

        fun VendorUiModel.toDomain(): Vendor = Vendor(
            vendorType = VendorType.fromCommercialName(vendorName),
            isAccepted = isAccepted
        )
    }
}
