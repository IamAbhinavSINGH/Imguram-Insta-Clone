package com.abhinav.imguram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.imguram.data.ImgurRepository
import com.abhinav.libimgurapi.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _tags = MutableLiveData<List<Tag>>()
    private val repo = ImgurRepository()
    val tags: LiveData<List<Tag>> = _tags

    fun fetchTags(){
        viewModelScope.launch(Dispatchers.IO){
            _tags.postValue(repo.getTags())
        }
    }

}