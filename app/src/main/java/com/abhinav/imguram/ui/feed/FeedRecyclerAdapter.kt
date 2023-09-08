package com.abhinav.imguram.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.abhinav.imguram.R
import com.abhinav.imguram.databinding.ListItemGalleryImageBinding
import com.abhinav.libimgurapi.models.Image

class FeedRecyclerAdapter():
    ListAdapter<Image, FeedRecyclerAdapter.FeedRecyclerViewHolder>(FeedDiffCallBack()){

    class FeedRecyclerViewHolder(val binding: ListItemGalleryImageBinding): RecyclerView.ViewHolder(binding.root){

    }

    private class FeedDiffCallBack: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRecyclerViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return FeedRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedRecyclerViewHolder, position: Int) {
        val image = getItem(position)

        holder.binding.galleryTextView.text = image.title
        holder.binding.galleryImageView.load("https://i.imgur.com/${image.cover}.jpg"){
            placeholder(R.drawable.placeholer_image)
            error(R.drawable.placeholer_image)
        }


    }
}