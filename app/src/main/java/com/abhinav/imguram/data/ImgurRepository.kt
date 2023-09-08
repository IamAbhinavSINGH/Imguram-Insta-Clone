package com.abhinav.imguram.data

import com.abhinav.libimgurapi.ImgurClient
import com.abhinav.libimgurapi.models.Gallery
import com.abhinav.libimgurapi.models.Image
import com.abhinav.libimgurapi.models.Tag
import com.abhinav.libimgurapi.models.TagsResponse
import com.abhinav.libimgurapi.params.Section

class ImgurRepository {

    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>?{ // TODO: Return proper error body
        val response = api.getGalleryResponse(Section.Hot)

        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>?{
        val response = api.getGalleryResponse(Section.Top)

        return response.body()?.data
    }

    suspend fun getTags(): List<Tag>? {
        val response = api.getTagsResponse()

        return response.body()?.data?.tags
    }

    suspend fun getTagGallery(tagName: String): List<Image>? {
        val response = api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}