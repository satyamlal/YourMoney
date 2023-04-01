package com.devsphere.yourmoney.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devsphere.yourmoney.Greeting
import com.devsphere.yourmoney.components.TableRow
import com.devsphere.yourmoney.ui.theme.BackgroundElevated
import com.devsphere.yourmoney.ui.theme.DividerColor
import com.devsphere.yourmoney.ui.theme.Shapes
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(navController: NavController) {
    Scaffold(topBar = {
        MediumTopAppBar(title = { Text("Categories") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ),
            navigationIcon = {
                Surface(onClick = navController::popBackStack,
                color = Color.Transparent) {
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
                TableRow("Categories", hasArrow = true, modifier = Modifier.clickable {
                    navController.navigate("settings/categories")
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
                TableRow("Erase all data", isDestructive = true)
            }
        }
    })
}