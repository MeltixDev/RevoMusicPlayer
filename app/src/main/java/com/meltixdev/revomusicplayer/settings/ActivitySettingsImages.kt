package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsImagesBinding

private lateinit var binding: ActivitySettingsImagesBinding

class ActivitySettingsImages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsImagesBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_settings_images)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}