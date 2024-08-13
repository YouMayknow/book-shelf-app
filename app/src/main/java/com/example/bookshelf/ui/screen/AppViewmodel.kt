package com.example.bookshelf.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.AppApplication
import com.example.bookshelf.data.BookRepository
import com.example.bookshelf.model.Thumbnails
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AppViewmodel(
    val bookRepository: BookRepository
) : ViewModel() {
   var exceptions  by mutableStateOf("")
  //  var appUiState : AppUiState by mutableStateOf(AppUiState.Loading)
        private  set
    var imageList  =   mutableStateListOf<String>()


    init {
        searchFunction(searchTerm =  "jazz history")
    }
    fun searchFunction(
        searchTerm : String
    ){
        viewModelScope.launch  {
          //  appUiState = AppUiState.Loading
            try {
              val imageIdList =   bookRepository.getBookList(searchTerm).items
                imageIdList.forEach { imageId ->
                  val thumbnail =   bookRepository.getBookImage(imageId.id).volumeInfo.imageLinks.thumbnail
                    imageList.add(thumbnail)
                }
            }  catch (e : IOException){
                exceptions = e.toString()
            }  catch (e : HttpException){
                exceptions = e.toString()
            }
        }

   // appUiState = AppUiState.Success(bookImages = imageList)
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