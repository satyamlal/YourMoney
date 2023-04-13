package com.devsphere.yourmoney.pages

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.ui.theme.TopAppBarBackground
import com.devsphere.yourmoney.ui.theme.YourMoneyTheme
import com.devsphere.yourmoney.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expenses(navController: NavController) {

    val recurrences = listOf(
        Recurrence.None,
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly,
    )

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Expenses") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text(
                        "Total for: ",
                        style = Typography.bodyMedium,
                    )
                    Text(state.recurrence?.target ?: Recurrence.None.target)
                    DropdownMenu(expanded = recurrenceMenuOpened,
                        onDismissRequest = { recurrenceMenuOpened = false }) {
                        recurrences.forEach { recurrence ->
                            DropdownMenuItem(text = { Text(recurrence.target) }, onClick = {
                                vm.setRecurrence(recurrence)
                                recurrenceMenuOpened = false
                            })
                        }
                    }
                }
            }
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ExpensePreview() {
    YourMoneyTheme {
        Expenses(navController = rememberNavController())
    }
}