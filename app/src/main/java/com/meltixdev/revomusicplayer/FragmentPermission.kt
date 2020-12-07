package com.meltixdev.revomusicplayer

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.FragmentPermissionBinding
import com.meltixdev.revomusicplayer.settings.ActivitySettings
import java.util.jar.Manifest

class FragmentPermission : Fragment(R.layout.fragment_permission) {

    private lateinit var binding: FragmentPermissionBinding

    companion object {
        var PERMISSION_REQUEST_CODE = 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPermissionBinding.bind(view)

        binding.topToolbar.inflateMenu(R.menu.menu_toolbar_home)

        binding.topToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.fsvSettings -> this.startActivity(Intent(activity, ActivitySettings::class.java))
            }
            true
        }

        binding.btnPermission.setOnClickListener {
            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:com.meltixdev.revomusicplayer")))
        }
    }
}