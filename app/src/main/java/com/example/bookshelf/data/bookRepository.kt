package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookApi

interface BookRepository  {
   suspend fun getBookList() : Book
}


class   NetworkBookRepository  (
   private  val retrofitService : BookApi ,

) : BookRepository {
    override suspend fun getBookList(): Book  =  retrofitService.getBookList()

}