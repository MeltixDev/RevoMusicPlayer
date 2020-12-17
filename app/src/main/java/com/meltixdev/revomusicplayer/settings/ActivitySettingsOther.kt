package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsOtherBinding

private lateinit var binding: ActivitySettingsOtherBinding

class ActivitySettingsOther : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsOtherBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings_other)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}