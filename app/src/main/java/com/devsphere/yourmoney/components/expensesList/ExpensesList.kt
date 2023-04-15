package com.devsphere.yourmoney.components.expensesList

import androidx.compose.runtime.Composable
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDay

@Composable
fun ExpensesList(expenses: List<Expense>) {
    val groupedExpenses = expenses.groupedByDay()
}