package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookImage
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface  BookApi {
    @GET("volumes")
   suspend  fun getBookList(
        @Query("q")
        query: String = "india past"
    ) : Book


   @GET("volumes/{id}")
   suspend fun getBookImage(
      @Path("id")id : String
   ) : BookImage
}