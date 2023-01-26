package com.bravedroid.calculator.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bravedroid.calculator.android.databinding.ActivityOnboardingBinding
import com.bravedroid.cmp.ConsentFragment

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dialog = ConsentFragment()
        binding.showCmpBtn.setOnClickListener {
            dialog.show(supportFragmentManager, "consentFragment")
        }
    }
}