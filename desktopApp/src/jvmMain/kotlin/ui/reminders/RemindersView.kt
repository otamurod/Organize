package ui.reminders

import androidx.compose.foundation.ContextMenuDataProvider
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import koin
import uz.otamurod.organize.Logger
import uz.otamurod.organize.presentation.RemindersViewModel

@Composable
fun RemindersView(
    viewModel: RemindersViewModel = koin.get(),
    onAboutButtonClick: () -> Unit,
) {
    Column {
        Toolbar(onAboutButtonClick = onAboutButtonClick)
        ContentView(viewModel = viewModel)
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
            IconButton(onClick = {
                onAboutButtonClick()
                Logger.log("Navigating to About Device Screen")
            },
                modifier = Modifier.semantics { contentDescription = "aboutButton" }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView(
    viewModel: RemindersViewModel
) {
    val reminders by viewModel.reminders.collectAsState()
    
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var shouldFocusOnTextField by remember { mutableStateOf(false) }
    
    var textFieldValue by remember { mutableStateOf("") }
    
    if (reminders.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = reminders) { item ->
                val onItemClick = {
                    focusManager.clearFocus(true)
                    viewModel.markReminder(id = item.id, isCompleted = !item.isCompleted)
                }
                
                val onItemDelete = {
                    focusManager.clearFocus(true)
                    viewModel.deleteReminder(item)
                }
                
                ContextMenuDataProvider(
                    items = {
                        listOf(
                            ContextMenuItem("Delete", onClick = onItemDelete)
                        )
                    }
                ) {
                    SelectionContainer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(enabled = true, onClick = onItemClick)
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ) {
                        ReminderItem(
                            title = item.title,
                            isCompleted = item.isCompleted,
                        )
                    }
                }
            }
            
            item {
                val onSubmit = {
                    viewModel.createReminder(title = textFieldValue)
                    textFieldValue = ""
                    shouldFocusOnTextField = true
                }
                
                NewReminderTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    onSubmit = onSubmit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .focusRequester(focusRequester)
                )
                
                LaunchedEffect(reminders) {
                    if (shouldFocusOnTextField) {
                        focusRequester.requestFocus()
                        shouldFocusOnTextField = false
                    }
                }
            }
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                val onSubmit = {
                    viewModel.createReminder(title = textFieldValue)
                    textFieldValue = ""
                    shouldFocusOnTextField = true
                }
                
                NewReminderTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    onSubmit = onSubmit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .focusRequester(focusRequester)
                )
                
                LaunchedEffect(reminders) {
                    if (shouldFocusOnTextField) {
                        focusRequester.requestFocus()
                        shouldFocusOnTextField = false
                    }
                }
            }
        }
    }
}

@Composable
private fun ReminderItem(
    title: String,
    isCompleted: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        RadioButton(
            selected = isCompleted,
            onClick = null
        )
        
        Text(
            text = title,
            style = if (isCompleted) {
                MaterialTheme.typography.bodyLarge.copy(
                    textDecoration = TextDecoration.LineThrough,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                )
            } else {
                MaterialTheme.typography.bodyLarge
            },
            modifier = Modifier.padding(8.dp)
                .selectable(false, enabled = true, onClick = {})
        )
    }
}

@Composable
private fun NewReminderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Add a new reminder here") },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = { onSubmit() }
        ),
        modifier = modifier
            .onPreviewKeyEvent { event: KeyEvent ->
                if (event.key == Key.Enter) {
                    onSubmit()
                    return@onPreviewKeyEvent true
                }
                false
            }
    )
}