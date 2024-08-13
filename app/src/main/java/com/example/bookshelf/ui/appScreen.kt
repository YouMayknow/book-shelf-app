package com.example.bookshelf.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.data.DefaultAppContainer
import com.example.bookshelf.ui.screen.AppViewmodel
import com.example.bookshelf.ui.screen.HomeScreen
import com.example.bookshelf.ui.screen.SuccessScreen
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@Composable
fun AppScreen (
) {
    val viewmodel: AppViewmodel = viewModel(factory = AppViewmodel.Factory)

    Scaffold(
    ) {
        HomeScreen(imageList = imageUrls,  onRetry = { /*TODO*/ }, modifier = Modifier.padding(it))
        /*

        var kind by remember { mutableStateOf("Loading...") }
        var url by remember { mutableStateOf("Trying...") }
        var  urls =  remember { mutableStateListOf<String>() }
        // Use a coroutine scope to run the network request
        val coroutineScope = rememberCoroutineScope()

        // Use LaunchedEffect to perform side-effects
        LaunchedEffect(Unit) {
            coroutineScope.launch {
                try {
                    // Fetch the data from the repository
                    val bookList = DefaultAppContainer().bookRepository.getBookList("jazz history")
                    bookList.items.forEach {
                        val   url1 = DefaultAppContainer().bookRepository.getBookImage(it.id)
                        url  =   url1.volumeInfo.imageLinks.thumbnail
                        urls.add(url)
                    }
                    // Update the 'kind' value on the main thread

                } catch (e : IOException){
                    url  = e.toString()            }
                catch (e : HttpException){
                    url   = e.toString()
                }
            }
        }

      viewmodel.searchFunction("jazz history")
      val imagelist  = remember { viewmodel.imageList }
      HomeScreen(
          imageList = urls    ,
          onRetry = { } , // viewmodel::appUiState
          modifier = Modifier.padding(it)
      )
        SuccessScreen(bookImages = urls , modifier =  Modifier.padding(it))
    }  */
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar (
    value   : String ,
    onValueChange : (String) -> Unit  ,
    modifier: Modifier = Modifier ,
    onSearch : () -> Unit ,
    onCancel : () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Row {
                TextField(
                    leadingIcon = {
                        IconButton(onClick = onCancel) {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = onSearch) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                        }
                    } ,
                    value = value   ,
                    onValueChange = onValueChange ,
                    modifier = modifier
                )
            }
        }
    )

}


val imageUrls = listOf(
    "https://images.unsplash.com/photo-1593642634367-d91a135587b5",
    "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0",
    "https://images.unsplash.com/photo-1606787366850-de6330128bfc",
    "https://images.unsplash.com/photo-1494173853739-c21f58b16055",
    "https://images.unsplash.com/photo-1498050108023-c5249f4df085",
    "https://images.unsplash.com/photo-1581092330270-f92eaaa5f4f9",
    "https://images.unsplash.com/photo-1581276879432-fc0f5d9d0d34",
    "https://images.unsplash.com/photo-1542281286-9e0a16bb7366",
    "https://images.unsplash.com/photo-1509223197845-458d87318791",
    "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
)