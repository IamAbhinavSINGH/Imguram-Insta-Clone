package com.abhinav.imguram.ui.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.abhinav.imguram.databinding.ActivityVideoBinding


class VideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private lateinit var link: String
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        link = intent.getStringExtra("link").toString()
        val title = intent.getStringExtra("title")

        binding.textView.text = title

        initializePlayer()
    }

    private fun initializePlayer(){
        player = ExoPlayer.Builder(this).build()
        binding.playerView.player = player

        val videoItem = MediaItem.fromUri(link)
        player.setMediaItem(videoItem)
        player.repeatMode = Player.REPEAT_MODE_ONE

        player.prepare()
        player.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        player.release()
    }
}