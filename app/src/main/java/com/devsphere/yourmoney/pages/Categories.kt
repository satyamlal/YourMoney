package com.devsphere.yourmoney.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

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
            Row() {
                if(uiState.colorPickerShowing) {
                    Dialog(onDismissRequest = { /*TODO*/ }) {
                        
                    }
                }
            }
        }
    })
}