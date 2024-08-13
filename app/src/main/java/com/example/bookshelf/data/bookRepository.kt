package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookImage
import com.example.bookshelf.network.BookApi

interface BookRepository {
     suspend fun getBookList(): Book
     suspend fun getBookImage(id : String)  : BookImage
}

class   NetworkBookRepository  (
   private  val retrofitService : BookApi ,
) : BookRepository {
        override suspend fun getBookList():Book {
       return retrofitService.getBookList()
    }
    override suspend fun getBookImage(id : String): BookImage {
       return retrofitService.getBookImage(id = id)
    }

}


