package com.meltixdev.revomusicplayer

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.ActivityMainBinding
import java.util.jar.Manifest

private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setTheme(R.style.Theme_Revo)
        setContentView(binding.root)

        val frgPermission = FragmentPermission()
        val frgHome = FragmentHome()
        val frgTrack = FragmentTrack()
        val frgAlbum = FragmentAlbum()
        val frgPlaylist = FragmentPlaylist()
        val frgSpotify = FragmentSpotify()

        if (ContextCompat.checkSelfPermission(
                        applicationContext,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            setCurrentFragment(frgPermission)
        } else {
            setCurrentFragment(frgHome)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bnHome -> {
                    if (ContextCompat.checkSelfPermission(
                                    applicationContext,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                        setCurrentFragment(frgPermission)
                    } else {
                        setCurrentFragment(frgHome)
                    }
                }
                R.id.bnTrack -> {
                    if (ContextCompat.checkSelfPermission(
                                    applicationContext,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                        setCurrentFragment(frgPermission)
                    } else {
                        setCurrentFragment(frgTrack)
                    }
                }
                R.id.bnAlbum -> {
                    if (ContextCompat.checkSelfPermission(
                                    applicationContext,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                        setCurrentFragment(frgPermission)
                    } else {
                        setCurrentFragment(frgAlbum)
                    }
                }
                R.id.bnPlaylist -> {
                    if (ContextCompat.checkSelfPermission(
                                    applicationContext,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                        setCurrentFragment(frgPermission)
                    } else {
                        setCurrentFragment(frgPlaylist)
                    }
                }
                R.id.bnSpotifyFav -> {
                    if (ContextCompat.checkSelfPermission(
                                    applicationContext,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                        setCurrentFragment(frgPermission)
                    } else {
                        setCurrentFragment(frgSpotify)
                    }
                }
                /*R.id.bnHome -> setCurrentFragment(frgHome)
                R.id.bnTrack -> setCurrentFragment(frgTrack)
                R.id.bnAlbum -> setCurrentFragment(frgAlbum)
                R.id.bnPlaylist -> setCurrentFragment(frgPlaylist)
                R.id.bnSpotifyFav -> setCurrentFragment(frgSpotify)*/
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutMain, fragment)
            commit()
        }
    }
}