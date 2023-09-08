package com.abhinav.imguram.ui.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.abhinav.imguram.R
import com.abhinav.imguram.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoryBinding
    private val storyViewModel by viewModels<StoryViewModel>()
    private val storyPagerAdapter = StoryViewPagerAdapter()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")

        tagName?.let{
            storyViewModel.fetchTagGallery(it)
        }

        binding.storyViewPager.adapter = storyPagerAdapter


        binding.storyViewPager.registerOnPageChangeCallback(pageChangeCallBack)
    }

    private val nextPageRunnable = Runnable{
        binding.storyViewPager.currentItem++
    }

    private val pageChangeCallBack = object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            binding.progressView.scaleX = 0F
            binding.progressView.animate().cancel()
            binding.progressView.animate().scaleX(1F).setDuration(5000).setStartDelay(10).start()

            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable, 5000)
        }
    }

    override fun onResume() {
        super.onResume()

        storyViewModel.images.observe(this){
            storyPagerAdapter.submitList(it)
        }
    }
}