package uz.otamurod.organize.android.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.organize.Logger
import uz.otamurod.organize.presentation.AboutViewModel

@Composable
fun AboutView(
    viewModel: AboutViewModel = AboutViewModel(),
    onUpButtonClick: () -> Unit
) {
    Column {
        Toolbar(onUpButtonClick = onUpButtonClick)
        ContentView(items = viewModel.items)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    onUpButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = {
                onUpButtonClick()
                Logger.log("Navigating Up")
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView(
    items: List<AboutViewModel.RowItem>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items) { row ->
            RowView(title = row.title, subtitle = row.subtitle)
        }
    }
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AboutView {
    }
}
