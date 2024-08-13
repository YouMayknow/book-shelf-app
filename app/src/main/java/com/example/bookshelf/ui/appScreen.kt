package com.example.bookshelf.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.data.DefaultAppContainer
import com.example.bookshelf.ui.screen.AppViewmodel
import com.example.bookshelf.ui.screen.HomeScreen
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@Composable
fun AppScreen (
) {
    val viewmodel: AppViewmodel = viewModel(factory = AppViewmodel.Factory)

    Scaffold(

    ) {
        viewmodel.getBooksList()
        HomeScreen(
            appUiState = viewmodel.appUiState ,
            onRetry = {viewmodel::appUiState } ,
            modifier = Modifier.padding(it)
        )
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



@Composable
fun FakeScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    // State to hold the 'kind' value
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
                val bookList = DefaultAppContainer().bookRepository.getBookList()
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
    // Display the 'kind' value

       // Text(text = kind)
       // Text(text = url.replace("http" , "https"))
    Column(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2) ,
           modifier =  Modifier.fillMaxSize() ,
            verticalArrangement = Arrangement.spacedBy(8.dp) ,
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(items = urls){ url ->
//                Text(text = url,
//                    fontSize = 20.sp
//                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(url.replace("http","https"))
                        .crossfade(true)
                        .build()
                    ,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(0.5f)  ,
                            contentDescription =  null
                )
            }
        }
    }
    }

val mockUrls = mutableListOf(
    "heroic adventures",
    "raja hindustani film",
    "mystical journeys",
    "ancient warrior tale",
    "galactic exploration",
    "legend of the kings",
    "mysterious labyrinth",
    "cosmic odyssey saga",
    "whispers in the wind",
    "enigmatic prophecy",
    "epic quest for glory",
    "timeless folklore",
    "tales of the unknown",
    "shadows of destiny",
    "forgotten realms saga"
)


@Composable
@Preview
fun FakeScreenPreview () {

}



