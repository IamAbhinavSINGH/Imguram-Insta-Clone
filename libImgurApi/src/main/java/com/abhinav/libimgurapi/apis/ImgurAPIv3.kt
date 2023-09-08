package com.abhinav.libimgurapi.apis

import com.abhinav.libimgurapi.models.GalleryResponse
import com.abhinav.libimgurapi.models.TagResponse
import com.abhinav.libimgurapi.models.TagsResponse
import com.abhinav.libimgurapi.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {

    @GET("gallery/{section}") // TODO: add path params
    suspend fun getGalleryResponse(
        @Path("section") i: Section,
        @Query("album_previews") AlbumPreviews: Boolean? = true
    ): Response<GalleryResponse>


    @GET("tags")
    suspend fun getTagsResponse(): Response<TagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag: String
    ): Response<TagResponse>
}