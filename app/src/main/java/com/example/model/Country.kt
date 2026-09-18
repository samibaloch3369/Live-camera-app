package com.example.model

data class Country(
    val id: String,
    val name: String,
    val flag: String,
    val subtitle: String,
    val cameraCount: Int,
    val badgeColorHex: Long = 0xFF00E5FF
)
