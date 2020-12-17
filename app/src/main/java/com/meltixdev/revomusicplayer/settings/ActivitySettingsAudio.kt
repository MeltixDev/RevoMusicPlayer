package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsAudioBinding

private lateinit var binding: ActivitySettingsAudioBinding

class ActivitySettingsAudio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsAudioBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings_audio)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }


}