package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookItem

sealed interface AppUiState {
 //   data class Success( val  books : List<BookItem>) : AppUiState
    data object Failure : AppUiState
    data object  Loading : AppUiState
}