package uz.otamurod.organize.android.ui.reminders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RemindersView(
  onAboutButtonClick: () -> Unit,
) {
  Column {
    Toolbar(onAboutButtonClick = onAboutButtonClick)
    ContentView()
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
  onAboutButtonClick: () -> Unit,
) {
  TopAppBar(
    title = { Text(text = "Reminders") },
    actions = {
      IconButton(onClick = onAboutButtonClick) {
        Icon(
          imageVector = Icons.Outlined.Info,
          contentDescription = "About Device Button",
        )
      }
    }
  )
}

@Composable
private fun ContentView() {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Text("Hello World!")
  }
}

@Preview(showBackground = true)
@Composable
private fun RemindersViewPreview() {
  RemindersView {
  }
}