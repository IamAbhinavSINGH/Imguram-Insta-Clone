package com.abhinav.imguram.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.abhinav.imguram.databinding.ListItemStoryHeadBinding
import com.abhinav.imguram.ui.story.StoryActivity
import com.abhinav.libimgurapi.models.Tag


class HomeStoriesRecyclerAdapter() :
    ListAdapter<Tag, HomeStoriesRecyclerAdapter.HomeStoriesViewHolder>(StoriesDiffCallBack()) {

    class HomeStoriesViewHolder(val binding: ListItemStoryHeadBinding) : RecyclerView.ViewHolder(binding.root){

    }

    private class StoriesDiffCallBack: DiffUtil.ItemCallback<Tag>(){
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding  = ListItemStoryHeadBinding.inflate(inflater,parent, false)

        return HomeStoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoriesViewHolder, position: Int) {
        val tag = getItem(position)

        holder.binding.homeTextView.text = tag.displayName
        holder.binding.homeImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
        holder.binding.root.apply {
          setOnClickListener {
                  context.startActivity(
                      Intent(context, StoryActivity::class.java).apply {
                          putExtra("tag", tag.name)
                      }
                  )
          }
        }
    }
}