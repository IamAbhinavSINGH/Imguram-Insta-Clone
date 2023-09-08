package com.abhinav.libimgurapi.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdConfig(
    @Json(name = "high_risk_flags")
    val highRiskFlags: List<Any>,
    @Json(name = "nsfw_score")
    val nsfwScore: Double,
    @Json(name = "safe_flags")
    val safeFlags: List<String>,
    @Json(name = "show_ad_level")
    val showAdLevel: Int,
    @Json(name = "show_ads")
    val showAds: Boolean,
    @Json(name = "showsAds")
    val showsAds: Boolean,
    @Json(name = "unsafe_flags")
    val unsafeFlags: List<String>,
    @Json(name = "wall_unsafe_flags")
    val wallUnsafeFlags: List<String>
)