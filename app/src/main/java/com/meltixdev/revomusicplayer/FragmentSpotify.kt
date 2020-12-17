package com.meltixdev.revomusicplayer

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.FragmentAlbumBinding
import com.meltixdev.revomusicplayer.databinding.FragmentHomeBinding
import com.meltixdev.revomusicplayer.databinding.FragmentSpotifyBinding
import com.meltixdev.revomusicplayer.settings.ActivitySettings

class FragmentSpotify : Fragment(R.layout.fragment_spotify) {

    private lateinit var binding: FragmentSpotifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_spotify, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSpotifyBinding.bind(view)

        binding.topToolbar.inflateMenu(R.menu.menu_toolbar_spotify)

        binding.topToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.fsvSettings -> this.startActivity(Intent(activity, ActivitySettings::class.java))
                R.id.fsvOpenSpotify -> {
                    if(isAppInstalled("com.spotify.music", context)) {
                        val appintent: Intent = context?.packageManager?.getLaunchIntentForPackage("com.spotify.music")!!
                        this.startActivity(appintent)
                    }
                }
            }
            true
        }
    }

    fun isAppInstalled(packageName: String, context: Context?): Boolean {
        return try {
            val packageManager = context?.packageManager
            packageManager?.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(context, context?.getString(R.string.notinstalled), Toast.LENGTH_SHORT).show()
            false
        }
    }
}