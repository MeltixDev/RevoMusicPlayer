package com.meltixdev.revomusicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setTheme(R.style.Theme_Revo)
        setContentView(binding.root)

        val frgHome = FragmentHome()
        val frgTrack = FragmentTrack()
        val frgAlbum = FragmentAlbum()
        val frgPlaylist = FragmentPlaylist()
        val frgSpotify = FragmentSpotify()

        setCurrentFragment(frgHome)

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
}