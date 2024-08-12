package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val selfLink  : String
)

@Serializable
data class BookImage(
    val thumbnail : String
)
