package com.abhinav.imguram.ui.feed

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.abhinav.imguram.R
import com.abhinav.imguram.databinding.ListItemGalleryImageBinding
import com.abhinav.imguram.ui.video.VideoActivity
import com.abhinav.libimgurapi.models.Image


class FeedRecyclerAdapter(): ListAdapter<Image, FeedRecyclerAdapter.FeedRecyclerViewHolder>(FeedDiffCallBack()) {

    class FeedRecyclerViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    private class FeedDiffCallBack : DiffUtil.ItemCallback<Image>() {
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
        holder.binding.galleryImageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.placeholer_image)
            error(R.drawable.placeholer_image)
        }

        holder.binding.galleryFullScreen.isVisible = false

        if(image.imagesCount != null && image.imagesCount!! > 0) {
            if(image.images?.get(0)?.type?.startsWith("video") == true) {
                holder.binding.galleryFullScreen.isVisible = true

                holder.binding.galleryFullScreen.apply{
                    setOnClickListener{
                        context.startActivity(
                            Intent(context, VideoActivity::class.java).apply {
                                putExtra("link", image.images!!.get(0).link)
                                putExtra("title", image.title)
                            }
                        )
                    }
                }
            }
        }
    }

}
