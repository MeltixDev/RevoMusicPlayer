package com.meltixdev.revomusicplayer.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivityAboutBinding

private lateinit var binding: ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_about)

        binding.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}