package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookImage
import com.example.bookshelf.model.BookItem
import retrofit2.http.GET
import retrofit2.http.Query


interface  BookApi {
    @GET("volumes")
   suspend  fun getBookList(
        @Query("q")
        query: String = "jazz history"
    ) : Book


   @GET("Volumes/{id}")
   suspend fun getBookImage(
       id : String = "AycJAQAAMAAJ"
   ) : List<BookImage>
}