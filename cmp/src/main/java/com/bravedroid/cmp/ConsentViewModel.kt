package com.bravedroid.cmp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ConsentViewModel @Inject constructor() : ViewModel() {
    private val _data = MutableStateFlow(
        listOf(
            "Google Crashlytics (to understand your interactions with the app crashes; sends data to Google)",
            "Google Firebase analytics (to understand your interactions with the app; sends data to Google)"
        )
    )
    val data = _data.asStateFlow()
}
