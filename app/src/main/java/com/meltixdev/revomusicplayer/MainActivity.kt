package com.meltixdev.revomusicplayer

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding
private val frgPermission = FragmentPermission()
private val frgHome = FragmentHome()
private val frgTrack = FragmentTrack()
private val frgAlbum = FragmentAlbum()
private val frgPlaylist = FragmentPlaylist()
private val frgSpotify = FragmentSpotify()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setTheme(R.style.Theme_Revo)
        setContentView(binding.root)

        requestPermissions(arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            FragmentPermission.PERMISSION_REQUEST_CODE
        )

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bnHome -> setCurrentFragment(frgHome)
                R.id.bnTrack -> setCurrentFragment(frgTrack)
                R.id.bnAlbum -> setCurrentFragment(frgAlbum)
                R.id.bnPlaylist -> setCurrentFragment(frgPlaylist)
                R.id.bnSpotifyFav -> setCurrentFragment(frgSpotify)
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == FragmentPermission.PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setCurrentFragment(frgHome)
                binding.bottomNavigationView.isVisible = true
            } else {
                setCurrentFragment(frgPermission)
                binding.bottomNavigationView.isVisible = false
            }
        }
    }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {
            setCurrentFragment(frgHome)
            binding.bottomNavigationView.isVisible = true
        }
    }
}