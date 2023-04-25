package com.devsphere.yourmoney.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devsphere.yourmoney.components.charts.MonthlyChart
import com.devsphere.yourmoney.components.charts.WeeklyChart
import com.devsphere.yourmoney.components.charts.YearlyChart
import com.devsphere.yourmoney.components.expensesList.ExpensesList
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.devsphere.yourmoney.ui.theme.Typography
import com.devsphere.yourmoney.viewmodels.ReportPageViewModel
import com.devsphere.yourmoney.viewmodels.viewModelFactory
import com.devsphere.yourmoney.utils.formatDayForRange
import java.time.LocalDate

@Composable
fun ReportPage(
    innerPadding: PaddingValues,
    page: Int,
    recurrence: Recurrence,
    vm: ReportPageViewModel = viewModel(
        key = "$page - ${recurrence.name}",
        factory = viewModelFactory {
        ReportPageViewModel(page, recurrence)
    })
) {
    val uiState = vm.uiState.collectAsState().value

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
                Text("${uiState.dateStart.formatDayForRange()} - ${uiState.dateEnd.formatDayForRange()}",
                    style = Typography.titleSmall,
                    modifier = Modifier.padding(start = 13.dp)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp, start = 13.dp)
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
                Text(
                    "Avg/day",
                    style = Typography.titleSmall,
                    modifier = Modifier.padding(end = 13.dp)
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        "₹",
                        style = Typography.bodyMedium,
                        color = LabelSecondary,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        "85",
                        style = Typography.headlineMedium,
                        modifier = Modifier.padding(end = 13.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .height(180.dp)
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            when (recurrence) {
                Recurrence.Weekly -> WeeklyChart(expenses = uiState.expenses)
                Recurrence.Monthly -> MonthlyChart(
                    expenses = uiState.expenses,
                    LocalDate.now()
                )
                Recurrence.Yearly -> YearlyChart(expenses = uiState.expenses)
                else -> Unit
            }

        }

        ExpensesList(
            expenses = mockExpenses,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        )
    }
}