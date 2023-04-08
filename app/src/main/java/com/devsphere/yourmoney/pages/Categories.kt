package com.devsphere.yourmoney.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.components.UnstyledTextField
import com.devsphere.yourmoney.ui.theme.*
import com.devsphere.yourmoney.viewmodels.CategoriesViewModel
import com.github.skydoves.colorpicker.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(navController: NavController, vm: CategoriesViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsState()

    val colorPickerController = rememberColorPickerController()

    Scaffold(topBar = {
        MediumTopAppBar(title = { Text("Categories") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ),
            navigationIcon = {
                Surface(
                    onClick = navController::popBackStack, color = Color.Transparent
                ) {
                    Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)) {
                        Icon(
                            Icons.Rounded.KeyboardArrowLeft,
                            contentDescription = "settings",
                        )
                        Text("Settings")
                    }
                }
            })
    }, content = { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.medium)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
            ) {
                TableRow("Groceries")
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )

                TableRow("Bills")
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )

                TableRow("Fruits")
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )

                TableRow("Vegetables")
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
            }
            Row(modifier = Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                if (uiState.colorPickerShowing) {
                    Dialog(onDismissRequest = vm::hideColorPicker) {
                        Surface(color = BackgroundElevated, shape = Shapes.large) {
                            Column(
                                modifier = Modifier
                                    .padding(all = 30.dp)
                            ) {
                                Text("Select a color", style = Typography.titleLarge)
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 24.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AlphaTile(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clip(RoundedCornerShape(6.dp)),
                                        controller = colorPickerController
                                    )
                                }
                                HsvColorPicker(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(300.dp)
                                        .padding(10.dp),
                                    controller = colorPickerController,
                                    onColorChanged = { envelope ->
                                        vm.setNewCategoryColor(envelope.color)
                                    },
                                )
                                Button(
                                    onClick = vm::hideColorPicker,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .align(alignment = Alignment.CenterHorizontally),
                                    shape = Shapes.large,
                                ) {
                                    Text("          Done            ")
                                }
                            }
                        }
                    }
                }
                Surface(
                    onClick = vm::showColorPicker,
                    shape = CircleShape,
                    color = uiState.newCategoryColor,
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.White
                    ),
                    modifier = Modifier.size(width = 24.dp, height = 24.dp)
                ) {}
                Surface(
                    color = BackgroundElevated,
                    modifier = Modifier
                        .height(44.dp)
                        .weight(1f)
                        .padding(start = 16.dp),
                    shape = Shapes.large,
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        UnstyledTextField(
                            value = uiState.newCategoryName,
                            onValueChange = vm::setNewCategoryName,
                            placeholder = { Text("Category name") },
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 1,
                        )
                    }
                }
                IconButton(
                    onClick = vm::createNewCategory,
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    Icon(
                        Icons.Rounded.Send,
                        "Create category"
                    )
                }
            }
        }
    })
}