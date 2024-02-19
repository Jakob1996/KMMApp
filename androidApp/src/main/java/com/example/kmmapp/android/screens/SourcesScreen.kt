package com.example.kmmapp.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kmmapp.android.screens.views.errors.ErrorMessage
import com.example.kmmapp.android.screens.views.toolbars.ToolbarWithBackIcon
import com.example.kmmapp.domain.entities.Source
import com.example.kmmapp.presentation.SourcesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SourcesScreen(
    sourceViewModel: SourcesViewModel = koinViewModel(),
    onUpButtonClick: () -> Unit
) {

    val sourcesState = sourceViewModel.sourcesState.collectAsState()

    Column {
        Toolbar(onUpButtonClick)

        when {

            sourcesState.value.error != null -> {
                sourcesState.value.error?.let {
                    ErrorMessage(it)
                }
            }

            sourcesState.value.sources.isNotEmpty() -> {
                SourcesListView(sourceViewModel.sourcesState.value.sources)
            }
        }
    }


}

@Composable
private fun Toolbar(onUpButtonClick: () -> Unit) {
    ToolbarWithBackIcon(onUpButtonClick, "Sources", "SourcesScreen")
}

@Composable
private fun SourcesListView(sourceList: List<Source>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(sourceList) { index, source ->
            SourcesRow(source)
        }
    }
}

@Composable
private fun SourcesRow(source: Source) {
    Column {
        AsyncImage(model = source.imageUrl, contentDescription = null)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = source.title, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = source.description)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier.align(Alignment.End),
            text = source.countryCode,
            style = TextStyle(color = Color.Gray)
        )
    }
}

@Preview
@Composable
fun SourcesScreenPreview() {
    SourcesScreen {

    }
}