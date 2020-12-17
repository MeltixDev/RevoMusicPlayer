package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsLookBinding

private lateinit var binding: ActivitySettingsLookBinding

class ActivitySettingsLook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsLookBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings_look)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}