package com.example.kmmapp.android.screens.views.toolbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarWithBackIcon(onUpButtonClick: () -> Unit, toolbarText: String, contentDescription: String) {
    TopAppBar(title = { Text(toolbarText) }, actions = {
        IconButton(onClick = onUpButtonClick) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = contentDescription)
        }
    })
}