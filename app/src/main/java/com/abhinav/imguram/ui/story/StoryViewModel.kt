package com.abhinav.imguram.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.imguram.data.ImgurRepository
import com.abhinav.libimgurapi.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {

    private val _images = MutableLiveData<List<Image>>()
    private val repo = ImgurRepository()
    val images: LiveData<List<Image>> = _images

    fun fetchTagGallery(tagName: String){
        viewModelScope.launch(Dispatchers.IO){
            _images.postValue(repo.getTagGallery(tagName))
        }
    }
}