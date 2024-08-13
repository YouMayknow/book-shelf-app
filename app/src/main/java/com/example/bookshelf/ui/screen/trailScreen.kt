package com.example.bookshelf.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.data.DefaultAppContainer
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


@Composable
fun heroScreen () {

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





    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 200.dp)
    ) {


        items(items = urls ,  ) {
            // BookDisplay(it)

            Card (
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio(0.67f)  ,
                shape = RectangleShape ,

                ) {
                Column {
                    //BookImage(bookImage = bookImage)
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.replace("http" , "https"))
                            .crossfade(true)
                            .build() ,
                        contentDescription =  null,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}