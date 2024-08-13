package com.example.bookshelf.data

import com.example.bookshelf.network.BookApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bookRepository  : BookRepository
}

class DefaultAppContainer : AppContainer {
   private val baseUrl = "https://www.googleapis.com/books/v1/"
    val json = Json { ignoreUnknownKeys = true } // Configure Kotlin Serialization

    private val retrofit : Retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory("application/Json".toMediaType()))
        .build()

    private val retroFitService: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }
    override val bookRepository: BookRepository by lazy {
        NetworkBookRepository(
            retrofitService = retroFitService ,
        )
    }
}