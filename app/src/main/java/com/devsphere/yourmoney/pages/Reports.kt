package com.devsphere.yourmoney.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devsphere.yourmoney.components.charts.WeeklyChart
import com.devsphere.yourmoney.components.expensesList.ExpensesList
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reports(navController: NavController) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("Expenses") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text("12 Sep - 28 Sep", style = Typography.titleSmall)
                        Row(
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                "₹",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("223.23", style = Typography.headlineMedium)
                        }
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text("Avg/day", style = Typography.titleSmall)
                        Row(
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                "₹",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Text("85", style = Typography.headlineMedium)
                        }
                    }
                }

                WeeklyChart(expenses = mockExpenses)

                ExpensesList(
                    expenses = mockExpenses,
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                )
            }
        }
    )
}