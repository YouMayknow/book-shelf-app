package com.example.bookshelf.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.data.DefaultAppContainer
import com.example.bookshelf.ui.screen.AppViewmodel
import com.example.bookshelf.ui.screen.HomeScreen
import kotlinx.coroutines.launch

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
fun FakeScreen() {
    // State to hold the 'kind' value
    var kind by remember { mutableStateOf("Loading...") }
    // Use a coroutine scope to run the network request
    val coroutineScope = rememberCoroutineScope()

    // Use LaunchedEffect to perform side-effects
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            // Fetch the data from the repository
            val bookList = DefaultAppContainer().bookRepository.getBookList()
            // Update the 'kind' value on the main thread
            kind = bookList.items.toString()

        }
    }

    // Display the 'kind' value
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = kind)

    }
}