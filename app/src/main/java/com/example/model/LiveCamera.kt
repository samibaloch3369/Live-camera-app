package com.example.model

data class LiveCamera(
    val id: String,
    val title: String,
    val city: String,
    val countryId: String,
    val countryName: String,
    val flag: String,
    val youtubeVideoId: String,
    val locationDescription: String,
    val cameraType: String = "Traffic 4K",
    val viewersCount: String = "1.2K",
    val trafficStatus: String = "Flowing",
    val tags: List<String> = emptyList()
) {
    /**
     * Generates a clean, privacy-friendly YouTube embed URL for WebView playback.
     */
    fun getEmbedUrl(): String {
        return "https://www.youtube-nocookie.com/embed/$youtubeVideoId?autoplay=1&mute=0&playsinline=1&controls=1&modestbranding=1&rel=0&enablejsapi=1"
    }

    /**
     * Standard watch URL for opening directly in YouTube app or external browser.
     */
    fun getWatchUrl(): String {
        return "https://www.youtube.com/watch?v=$youtubeVideoId"
    }
}
