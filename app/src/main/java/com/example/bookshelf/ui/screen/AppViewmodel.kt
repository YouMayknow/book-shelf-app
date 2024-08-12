package com.example.bookshelf.ui.screen

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.AppApplication
import com.example.bookshelf.data.BookRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AppViewmodel(
    val bookRepository: BookRepository
) : ViewModel() {
    var appUiState : AppUiState by mutableStateOf(AppUiState.Loading)
        private  set
    lateinit var query : String


    init {
        getBooksList()
    }
    fun getBooksList()  {
       // query = "jazz history"
        viewModelScope.launch  {
            appUiState = AppUiState.Loading
            try {
                AppUiState.Success(bookRepository.getBookList())
            }
            catch (e : IOException){
                AppUiState.Failure
            }
            catch (e : HttpException){
                AppUiState.Failure
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AppApplication)
                val bookRepository = application.appContianer.bookRepository
                AppViewmodel(bookRepository = bookRepository)
            }
        }
    }

}