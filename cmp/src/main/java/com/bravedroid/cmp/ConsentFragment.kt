package com.bravedroid.cmp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bravedroid.cmp.databinding.FragmentConsentBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ConsentFragment : DialogFragment() {
    private val consentViewModel by viewModels<ConsentViewModel>()

    private var _binding: FragmentConsentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentConsentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = consentViewModel.data.value
        binding.appCompatCheckBox1.text = data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
