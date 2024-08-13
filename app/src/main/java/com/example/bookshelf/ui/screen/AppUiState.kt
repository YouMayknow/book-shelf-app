package com.example.bookshelf.ui.screen

sealed interface AppUiState {
    data class Success( val  bookId : List<String> ) : AppUiState
    // here bookImage is repelaced by string .
    data object Failure : AppUiState
    data object  Loading : AppUiState
}