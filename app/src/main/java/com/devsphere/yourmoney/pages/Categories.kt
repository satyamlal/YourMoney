package com.devsphere.yourmoney.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.skydoves.colorpicker.compose.*
import com.devsphere.yourmoney.R
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.components.UnstyledTextField
import com.devsphere.yourmoney.ui.theme.*
import com.devsphere.yourmoney.viewmodels.CategoriesViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class
)
@Composable
fun Categories(navController: NavController, vm: CategoriesViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsState()

    val swipeableState = rememberDismissState()

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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(Shapes.medium)
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                ) {
                    itemsIndexed(uiState.categories) { index, category ->
                        SwipeToDismiss(
                            state = swipeableState,
                            dismissContent = {
                                TableRow() {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
//                                modifier = Modifier.padding(horizontal = 16.dp)
                                    ) {
                                        Surface(
                                            color = category.color,
                                            shape = CircleShape,
//                                    border = BorderStroke(
//                                        width = 2.dp,
//                                        color = Color.White,
//                                    ),
                                            modifier = Modifier.size(12.dp),
                                        ) {}
                                        Text(
                                            category.name,
                                            modifier = Modifier.padding(
                                                horizontal = 10.dp,
                                                vertical = 6.dp
                                            )
                                        )
                                    }
                                }
                            },
                            background = {
                                         Text("Testing UI")
                            },
                            directions = setOf(DismissDirection.EndToStart)
                        )
                        if (index < uiState.categories.size - 1) {
                            Divider(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                                thickness = 1.dp,
                                color = DividerColor
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
//                    .defaultMinSize(minHeight = 44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
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
                                ) { Text("          Done            ") }
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
                        "Create a category"
                    )
                }
            }
        }
    })
}