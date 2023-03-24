package com.devsphere.yourmoney.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.components.UnstyledTextField
import com.devsphere.yourmoney.ui.theme.*
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavController) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
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
                            modifier = Modifier.fillMaxWidth(),
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
                    TableRow("Recurrence")

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
                    TableRow("Note")

                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow("Category")
                }
            }
        }
    )
}