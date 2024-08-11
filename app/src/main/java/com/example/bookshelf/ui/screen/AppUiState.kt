package com.example.bookshelf.ui.screen

sealed interface AppUiState {
    data object Success
    data object Failure
    data object  Loading
}