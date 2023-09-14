package com.abhinav.imguram.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.ViewSizeResolver
import com.abhinav.imguram.R
import com.abhinav.imguram.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = HomeStoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = storiesAdapter
        }


        setUpNavigationBar()

        homeViewModel.fetchTags()
    }

    private fun setUpNavigationBar(){
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)


          //  TODO: NOT USING ACTION BAR FOR NOW
          //  ---------------- ACTIONBAR CODE---------------------
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_hot, R.id.navigation_top
                )
            )

           // ----------------------ACTIONBAR CODE---------------------------------


      //  val appBarConfiguration = AppBarConfiguration(setOf("Imguram"))
        setupActionBarWithNavController(navController, appBarConfiguration )

        navView.setupWithNavController(navController)

    }

    override fun onResume() {
        super.onResume()

        homeViewModel.tags.observe(this){ it ->
            storiesAdapter.submitList(it)
        }
    }
}