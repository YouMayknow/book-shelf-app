package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import retrofit2.http.GET
import retrofit2.http.Query


interface  BookApi {
    @GET("volumes")
   suspend  fun getBookList(
        @Query("q")
        query: String = "jazz history"
    ) : Book
}