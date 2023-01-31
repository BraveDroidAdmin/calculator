package com.bravedroid.calculator.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bravedroid.calculator.android.databinding.ActivityOnboardingBinding
import com.bravedroid.cmp.presentation.ConsentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = ConsentFragment()
        binding.showCmpBtn.setOnClickListener {
            dialog.show(supportFragmentManager, "consentFragment")
        }
    }
}
