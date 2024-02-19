package com.example.kmmapp.features.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    val status: String,
    val sources: List<SourcesRow>
)

@Serializable
data class SourcesRow(
    val id: String?,
    val name: String?,
    val description: String?,
    @SerialName("url")
    val url: String?,
    val category: String?,
    val language: String?,
    val country: String?
)
