package com.bravedroid.cmp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ConsentViewModel @Inject constructor() : ViewModel() {
    private val _data = MutableStateFlow("DUMP Data")
    val data = _data.asStateFlow()
}
