package com.bravedroid.cmp.domain.vendors

import com.bravedroid.cmp.domain.repository.CmpLocalRepository
import javax.inject.Inject

class GetAllVendorsUseCase @Inject constructor(
    private val cmpLocalRepository: CmpLocalRepository,
) {
    operator fun invoke(): List<Vendor> = cmpLocalRepository.getAllVendors()
}
