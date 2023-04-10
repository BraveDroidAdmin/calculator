package com.bravedroid.calculator.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.calculator.android.databinding.ActivityOnboardingBinding
import com.bravedroid.cmp.presentation.ConsentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = ConsentFragment()
        dialog.show(supportFragmentManager, "consentFragment")

        binding.showCmpBtn.setOnClickListener {
            dialog.show(supportFragmentManager, "consentFragment")
        }
    }
}
