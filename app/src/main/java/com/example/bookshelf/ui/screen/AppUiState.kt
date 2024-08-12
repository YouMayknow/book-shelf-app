package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.Book

sealed interface AppUiState {
    data class Success( val  books : Book) : AppUiState
    data object Failure : AppUiState
    data object  Loading : AppUiState
}