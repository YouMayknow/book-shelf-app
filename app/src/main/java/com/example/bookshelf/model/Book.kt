package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val kind: String,
    val totalItems: Int,
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val kind: String,
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val publisher: String? = null,
    val publishedDate: String? = null,
    val description: String? = null
)
