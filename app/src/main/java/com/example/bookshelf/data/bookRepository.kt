package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookApi

interface BookRepository : BookApi {
    override suspend fun getBookList(query: String): List<Book>
}


class   NetworkBookRepository  (
   private  val retrofitService : BookApi ,
    val query: String
) : BookRepository {
        override suspend fun getBookList(query: String): List<Book> {
       return retrofitService.getBookList(query = query)
    }


}