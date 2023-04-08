package com.devsphere.yourmoney.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
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
import com.devsphere.yourmoney.ui.theme.BackgroundElevated
import com.devsphere.yourmoney.ui.theme.DividerColor
import com.devsphere.yourmoney.ui.theme.Shapes
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground
import com.devsphere.yourmoney.viewmodels.CategoriesViewModel
import com.github.skydoves.colorpicker.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(navController: NavController, vm : CategoriesViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsState()

    val colorPickerController = rememberColorPickerController()
    colorPickerController.selectedColor.value

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
    },content = { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier =  Modifier
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
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                if(uiState.colorPickerShowing) {
                    Dialog(onDismissRequest =  vm::hideColorPicker )    {
                        // on below line we are creating a column,
                        Column(
                            // on below line we are adding a modifier to it,
                            modifier = Modifier
                                .fillMaxSize()
                                // on below line we are adding a padding.
                                .padding(all = 30.dp)
                        ) {
                            // on below line we are adding a row.
                            Row(
                                // on below line we are adding a modifier
                                modifier = Modifier.fillMaxWidth(),
                                // on below line we are adding horizontal
                                // and vertical alignment.
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // on below line we are adding a alpha tile.
                                AlphaTile(
                                    // on below line we are
                                    // adding modifier to it
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        // on below line
                                        // we are adding a height.
                                        .height(60.dp)
                                        // on below line we are adding clip.
                                        .clip(RoundedCornerShape(6.dp)),
                                    // on below line we are adding controller.
                                    controller = colorPickerController
                                )
                            }
                            // on below line we are
                            // adding horizontal color picker.
                            HsvColorPicker(
                                // on below line we are
                                // adding a modifier to it
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(450.dp)
                                    .padding(10.dp),
                                // on below line we are
                                // adding a controller
                                controller = colorPickerController,
                                // on below line we are
                                // adding on color changed.
                                onColorChanged = {}
                            )
                            // on below line we are adding a alpha slider.
                            AlphaSlider(
                                // on below line we
                                // are adding a modifier to it.
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(35.dp),
                                // on below line we are
                                // adding a controller.
                                controller = colorPickerController,
                                // on below line we are
                                // adding odd and even color.
                                tileOddColor = Color.White,
                                tileEvenColor = Color.Black
                            )
                            // on below line we are
                            // adding a brightness slider.
                            BrightnessSlider(
                                // on below line we
                                // are adding a modifier to it.
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(35.dp),
                                // on below line we are
                                // adding a controller.
                                controller = colorPickerController,
                            )
                        }
                    }
                Surface(
                    onClick = vm::showColorPicker,
                    shape = CircleShape,
                    color = uiState.newCategoryColor,
                    modifier = Modifier.size(width = 24.dp, height = 24.dp)
                ) {}
                }
            }
        }
    })
}