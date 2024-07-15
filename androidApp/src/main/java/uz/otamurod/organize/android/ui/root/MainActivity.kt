package uz.otamurod.organize.android.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.organize.android.R
import uz.otamurod.organize.android.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)

    setContent {
      AppTheme {
        AppScaffold()
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
  AppTheme {
    AppScaffold()
  }
}