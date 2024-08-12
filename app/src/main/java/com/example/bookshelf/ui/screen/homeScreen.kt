package com.example.bookshelf.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.model.Book


@Composable
fun HomeScreen (
    appUiState: AppUiState ,
    onRetry: () -> Unit ,
    modifier: Modifier = Modifier
) {

    when(appUiState){
       is  AppUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
       is  AppUiState.Success -> SuccessScreen(modifier = Modifier.fillMaxSize() , books = appUiState.books )
       is  AppUiState.Failure -> ErrorScreen(onRetry =  onRetry , modifier = Modifier.fillMaxSize())

    }
}
@Composable
fun LoadingScreen (modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.loading_img) ,
        contentDescription =  null ,
        modifier =  modifier.size(200.dp)
    )
}

@Composable
fun ErrorScreen (
    modifier: Modifier = Modifier ,
    onRetry : () -> Unit
) {
    Column(
        modifier = modifier ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null
        )
        Button(onClick = onRetry ) {
            Text(text = "Retry")
        }
    }
}

@Composable
fun SuccessScreen  (
    books : Book ,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 200.dp)
    ) {
//        items(items = books , key = {it -> it.kind} ) {
//            Text(text = it.kind)
//        }
       // item { Text(text = books.kind) }
    }
}

@Composable
fun BookDisplay (
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(0.67f)  ,
        shape = RectangleShape ,

    ) {
        Column {
            // Async image here
            Text(
                text = "Book name " ,
                modifier = Modifier.padding(
                    vertical = 8.dp,
                    horizontal = 4.dp
                )
            )
        }
    }
}