package ui.about

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import uz.otamurod.organize.presentation.AboutViewModel
import kotlin.math.max
import kotlin.math.min

@Composable
fun AboutView(viewModel: AboutViewModel = AboutViewModel()) {
    ContentView(items = viewModel.items)
}

@Composable
private fun ContentView(items: List<AboutViewModel.RowItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .semantics {
                contentDescription = "aboutView"
            },
    ) {
        items(items) { row ->
            RowView(title = row.title, subtitle = row.subtitle)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = uz.otamurod.organize.Platform()
    
    // Create a list of pairs
    val items = mutableListOf<Pair<String, String>>(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("CPU", platform.cpuType)
    )
    
    // Add the display information
    val max = max(platform.screen.width, platform.screen.height)
    val min = min(platform.screen.width, platform.screen.height)
    
    var displayInfo = "${max}×${min}"
    platform.screen.density?.let {
        displayInfo += " ${it}x"
    }
    items.add(Pair("Display", displayInfo))
    
    return items
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
        Divider()
    }
}

@Preview
@Composable
private fun RowViewPreview() {
    LazyColumn {
        items(5) {
            RowView(
                title = "Title",
                subtitle = "Subtitle",
            )
        }
    }
}
