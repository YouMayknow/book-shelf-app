package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val id : String
)

@Serializable
data class BookImage(
    val thumbnail : String
)
