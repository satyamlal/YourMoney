package com.devsphere.yourmoney

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devsphere.yourmoney.pages.*
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground
import com.devsphere.yourmoney.ui.theme.YourMoneyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourMoneyTheme {
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    bottomBar = {
                        NavigationBar(containerColor = TopAppBarBackground) {
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "expenses",
                                onClick = { navController.navigate("expenses") },
                                label = {
                                    Text("Expense")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.upload),
                                        contentDescription = "Upload"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "reports",
                                onClick = { navController.navigate("reports") },
                                label = {
                                    Text("Reports")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.reports),
                                        contentDescription = "Reports"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "add",
                                onClick = { navController.navigate("add") },
                                label = {
                                    Text("Add")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.add),
                                        contentDescription = "Add"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route?.startsWith("settings") ?: false,
                                onClick = { navController.navigate("settings") },
                                label = {
                                    Text("Settings")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.settings),
                                        contentDescription = "Settings"
                                    )
                                }
                            )
                        }
                    },
                    content = { innerPadding ->
                        NavHost(navController = navController, startDestination = "expenses") {
                            composable("expenses") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Expenses(navController)
                                }
                            }

                            composable("reports") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Reports(navController)
                                }
                            }

                            composable("add") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Add(navController)
                                }
                            }

                            composable("settings") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Settings(navController)
                                }
                            }

                            composable("settings/categories") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Greeting("Categories")
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    YourMoneyTheme {
        Surface {
            Greeting("Android")
        }
    }
}