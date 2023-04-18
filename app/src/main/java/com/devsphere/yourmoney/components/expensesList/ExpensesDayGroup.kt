package com.devsphere.yourmoney.components.expensesList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devsphere.yourmoney.models.DayExpenses
import com.devsphere.yourmoney.ui.theme.LabelSecondary
import com.devsphere.yourmoney.ui.theme.Typography
import com.devsphere.yourmoney.utils.formatDay
import java.text.DecimalFormat
import java.time.LocalDate

@Composable
fun ExpensesDayGroup(date: LocalDate, dayExpenses: DayExpenses, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            date.formatDay(),
            style = Typography.headlineMedium,
            color = LabelSecondary
        )
        Divider(modifier = Modifier.padding(top = 10.dp, bottom = 4.dp))
        dayExpenses.expenses.forEach { expense ->
            ExpenseRow(
                expense = expense,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
        Divider(modifier = Modifier.padding(top = 16.dp, bottom = 4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "Total: ",
                style = Typography.headlineMedium,
                color = LabelSecondary,
            )
            Text(
                DecimalFormat("₹ 0.#").format(dayExpenses.total),
                style = Typography.headlineMedium,
                color = LabelSecondary
            )
        }
    }
}