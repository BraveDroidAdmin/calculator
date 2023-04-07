package com.bravedroid.cmp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.bravedroid.cmp.databinding.FragmentConsentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsentFragment : DialogFragment() {
    private val consentViewModel by viewModels<ConsentViewModel>()

    private var _binding: FragmentConsentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showsDialog = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentConsentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        consentViewModel.loadVendors()

        val adapter = ConsentRequestAdapter()
        binding.cmpVendorRecycler.adapter = adapter
        val vendorUiModelList = consentViewModel.vendors.value
        adapter.submitList(vendorUiModelList)

        binding.acceptButton.setOnClickListener {
            consentViewModel.saveVendorsState()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
