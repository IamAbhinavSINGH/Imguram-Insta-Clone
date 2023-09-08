package com.abhinav.imguram.ui.story

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.imguram.databinding.PageItemStoryBinding
import com.abhinav.libimgurapi.models.Image
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import java.io.File

class StoryViewPagerAdapter() :
    ListAdapter<Image, StoryViewPagerAdapter.StoryViewHolder>(StoryDiffCallBack()) {

    class StoryViewHolder(val binding: PageItemStoryBinding) : RecyclerView.ViewHolder(binding.root){
    }

    class StoryDiffCallBack: DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean = (oldItem == newItem)
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean = (oldItem === newItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val infalter = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(infalter, parent, false)

        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val image = getItem(position)

        val imgUrl = if(image?.isAlbum == true && image.imagesCount != 0){
            image.images!![0].link
        }
        else{
            image.link
        }

        if (imgUrl != null) {
            Log.e("gifv", imgUrl)
        }

        imgUrl?.let{

            if(imgUrl.endsWith("gif")) {
                Glide.with(holder.binding.storyImageView.context)
                    .asGif()
                    .load(imgUrl)
                    .into(holder.binding.storyImageView)
            }
            else {
                Glide.with(holder.binding.storyImageView.context)
                    .load(imgUrl)
                    .into(holder.binding.storyImageView)
            }
        }

        cacheNextImage(position, holder.binding.storyImageView)
    }

    private fun cacheNextImage(position: Int, imageView: ImageView){
        val image = try{ getItem(position+1 ) }catch (e: Exception){null}

        val imgUrl = if(image != null && image.isAlbum == true && image.imagesCount != 0){
            image.images!![0].link
        }
        else{
            image?.link
        }

        imgUrl?.let{
            if(imgUrl.endsWith("gif")) {
                Glide.with(imageView.context)
                    .asGif()
                    .load(imgUrl)
                    .preload(500,500)
            }
            else {
                Glide.with(imageView.context)
                    .load(imgUrl)
                    .preload(500, 500)
            }
        }
    }
}