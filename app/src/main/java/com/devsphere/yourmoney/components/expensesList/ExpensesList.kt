package com.devsphere.yourmoney.components.expensesList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devsphere.yourmoney.components.ExpensesDayGroup
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDay

@Composable
fun ExpensesList(expenses: List<Expense>, modifier: Modifier = Modifier) {
    val groupedExpenses = expenses.groupedByDay()

    Column(modifier = modifier) {
        if (groupedExpenses.isEmpty()) {
            Text("No data for selected date range.", modifier = Modifier.padding(top = 32.dp))
        } else {
            groupedExpenses.keys.forEach { date ->
                if (groupedExpenses[date] != null) {
                    ExpensesDayGroup(
                        date = date,
                        dayExpenses = groupedExpenses[date]!!,
                        modifier = Modifier.padding(top = 24.dp)
                    )
                }
            }
        }
    }
}