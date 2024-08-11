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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScreen (
    modifier: Modifier = Modifier
) {
    Scaffold(
        
    ) {
        Text(text = "dsfdf" , modifier =  Modifier.padding(it))
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