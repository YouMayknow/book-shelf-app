package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookImage
import com.example.bookshelf.model.BookItem

sealed interface AppUiState {
    data class Success( val  bookId : List<BookImage> ) : AppUiState
    data object Failure : AppUiState
    data object  Loading : AppUiState
}