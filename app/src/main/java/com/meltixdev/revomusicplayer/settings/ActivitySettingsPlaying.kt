package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsPlayingBinding

private lateinit var binding: ActivitySettingsPlayingBinding

class ActivitySettingsPlaying : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsPlayingBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings_playing)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}