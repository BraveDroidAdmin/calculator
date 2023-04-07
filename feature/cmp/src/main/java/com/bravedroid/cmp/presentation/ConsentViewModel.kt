package com.bravedroid.cmp.presentation

import androidx.lifecycle.ViewModel
import com.bravedroid.cmp.domain.vendors.GetAllVendorsUseCase
import com.bravedroid.cmp.domain.vendors.SaveVendorsStateUseCase
import com.bravedroid.cmp.presentation.VendorUiModel.Companion.toDomain
import com.bravedroid.cmp.presentation.VendorUiModel.Companion.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ConsentViewModel @Inject constructor(
    private val getAllVendorsUseCase: GetAllVendorsUseCase,
    private val saveVendorsStateUseCase: SaveVendorsStateUseCase,
) : ViewModel() {

    private val _vendors = MutableStateFlow<List<VendorUiModel>>(emptyList())
    val vendors = _vendors.asStateFlow()

    fun loadVendors() {
        getAllVendorsUseCase().let { allVendors ->

            _vendors.value = allVendors.map {
                it.toUiModel()
            }
        }
    }

    fun saveVendorsState() {
        val vendorList = _vendors.value.map { it.toDomain() }
        saveVendorsStateUseCase(vendorList)
    }
}

