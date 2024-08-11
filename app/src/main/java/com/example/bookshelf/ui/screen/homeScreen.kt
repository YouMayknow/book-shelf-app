package com.example.bookshelf.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen (
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(minSize = 200.dp)
    ) {

    }
}

@Composable
fun BookDisplay (
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier.padding(4.dp)
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