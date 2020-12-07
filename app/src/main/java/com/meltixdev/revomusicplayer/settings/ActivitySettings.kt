package com.meltixdev.revomusicplayer.settings

import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsBinding

class ActivitySettings : AppCompatActivity() {

    private lateinit var binder: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.topToolbarBack.setNavigationOnClickListener {
            finish()
        }
    }
}