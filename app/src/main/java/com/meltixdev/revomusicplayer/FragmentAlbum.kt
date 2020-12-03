package com.meltixdev.revomusicplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meltixdev.revomusicplayer.databinding.FragmentAlbumBinding
import com.meltixdev.revomusicplayer.databinding.FragmentHomeBinding
import com.meltixdev.revomusicplayer.databinding.FragmentPlaylistBinding

class FragmentAlbum : Fragment(R.layout.fragment_album) {

    private lateinit var binding: FragmentAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_album, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAlbumBinding.bind(view)

        binding.topToolbar.inflateMenu(R.menu.menu_toolbar)
    }
}