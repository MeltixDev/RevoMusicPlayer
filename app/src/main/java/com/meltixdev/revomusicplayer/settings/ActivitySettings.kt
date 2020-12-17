package com.meltixdev.revomusicplayer.settings

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.meltixdev.revomusicplayer.R
import com.meltixdev.revomusicplayer.adapters.AdapterSettings
import com.meltixdev.revomusicplayer.databinding.ActivitySettingsBinding
import com.meltixdev.revomusicplayer.dataclasses.DataItemSettings

class ActivitySettings : AppCompatActivity(), AdapterSettings.OnItemClickListener {

    private lateinit var binder: ActivitySettingsBinding

    val SettingsList = listOf(
            DataItemSettings(getString(R.string.look), getString(R.string.lookdescription), R.drawable.ic_colored_color_lens),
            DataItemSettings(getString(R.string.playing), getString(R.string.playingdescription), R.drawable.ic_colored_view_carousel),
            DataItemSettings(getString(R.string.images), getString(R.string.imagesdscription), R.drawable.ic_colored_image),
            DataItemSettings(getString(R.string.audio), getString(R.string.audiodescription), R.drawable.ic_colored_volume_up),
            DataItemSettings(getString(R.string.other), getString(R.string.otherdescription), R.drawable.ic_colored_shape),
            DataItemSettings(getString(R.string.about), getString(R.string.aboutdescription), R.drawable.ic_colored_info)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.topToolbarBack.setNavigationOnClickListener {
            finish()
        }

        val adapter = AdapterSettings(SettingsList, this)
        binder.rvSettings.adapter = adapter
        binder.rvSettings.layoutManager = LinearLayoutManager(this)
    }

    override fun OnItemClick(position: Int) {
        when (position) {
            0 -> this.startActivity(Intent(this, ActivitySettingsLook::class.java))
            1 -> this.startActivity(Intent(this, ActivitySettingsPlaying::class.java))
            2 -> this.startActivity(Intent(this, ActivitySettingsImages::class.java))
            3 -> this.startActivity(Intent(this, ActivitySettingsAudio::class.java))
            4 -> this.startActivity(Intent(this, ActivitySettingsOther::class.java))
            5 -> this.startActivity(Intent(this, ActivityAbout::class.java))
        }
    }

}