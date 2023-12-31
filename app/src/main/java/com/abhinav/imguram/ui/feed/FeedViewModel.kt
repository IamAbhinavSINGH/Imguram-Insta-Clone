package com.abhinav.imguram.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.imguram.data.ImgurRepository
import com.abhinav.libimgurapi.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<Image>>()

    val feed : LiveData<List<Image>> = _feed

    fun updateFeed(feedType: String){
        viewModelScope.launch(Dispatchers.IO) {
            when(feedType){
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else -> Log.e("FEED" , "Feed has to be either hot or top")
            }
        }
    }


}