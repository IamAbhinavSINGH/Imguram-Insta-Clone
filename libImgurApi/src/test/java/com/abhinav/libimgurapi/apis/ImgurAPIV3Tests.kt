package com.abhinav.libimgurapi.apis

import com.abhinav.libimgurapi.ImgurClient
import com.abhinav.libimgurapi.params.Section
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ImgurAPIV3Tests {

    val api = ImgurClient.api

    @Test
    fun `get tags working`() = runBlocking{
        val response = api.getTagsResponse()
        assertNotNull(response.body())
    }

    @Test
    fun `get tags - aww working`() = runBlocking{
        val response = api.getTagGallery("aww")
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - hot working`() = runBlocking{
        val response = api.getGalleryResponse(Section.Hot)
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - top working`() = runBlocking{
        val response = api.getGalleryResponse(Section.Top)
        assertNotNull(response.body())
    }
}