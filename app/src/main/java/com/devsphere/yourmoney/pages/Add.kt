package com.devsphere.yourmoney.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.components.UnstyledTextField
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.ui.theme.*
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavController) {

    val recurrences = listOf(
        "None",
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly"
    )

    var selectedRecurrence by remember {
        mutableStateOf(recurrences[0])
    }

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(Shapes.large)
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                ) {
                    TableRow(label = "Amount") {
                        UnstyledTextField(
                            value = "Hello",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp)
                                .height(44.dp),
                            textStyle = TextStyle(
                                textAlign = TextAlign.End,
                            )
                        )
                    }
                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow("Recurrence") {
                        var recurrenceMenuOpened by remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { recurrenceMenuOpened = true }) {
                            Text(selectedRecurrence)
                            DropdownMenu(
                                expanded = recurrenceMenuOpened,
                                onDismissRequest = { recurrenceMenuOpened = false }) {
                                recurrences.forEach { recurrence ->
                                    DropdownMenuItem(
                                        text = { Text(recurrence) },
                                        onClick = {
                                            selectedRecurrence = recurrence
                                            recurrenceMenuOpened = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow("Date")

                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow("Note") {
                        UnstyledTextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text("Leave some notes") },
                            modifier = Modifier.fillMaxWidth(),
                            arrangement = Arrangement.End,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right,
                            ),
                        )
                    }

                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow("Category")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(16.dp),
                    shape = Shapes.large,
                ) {
                    Text("Submit Expenses")
                }
            }
        }
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAdd() {
    YourMoneyTheme {
        val navController = rememberNavController()
        Add(navController = navController)
    }
}