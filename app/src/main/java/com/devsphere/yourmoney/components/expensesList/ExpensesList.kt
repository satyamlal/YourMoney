package com.devsphere.yourmoney.components.expensesList

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDay
import com.devsphere.yourmoney.ui.theme.YourMoneyTheme

@Composable
fun ExpensesList(expenses: List<Expense>) {
    val groupedExpenses = expenses.groupedByDay()

    LazyColumn() {
        itemsIndexed(
            ArrayList(groupedExpenses.keys),
        key = {_, date -> date}
        ) { _, date ->
            if(groupedExpenses[date] != null) {
                ExpensesDayGroup(date = date, dayExpenses = groupedExpenses[date]!!)
            }
        }
    }
}

@Preview (showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    YourMoneyTheme {
        ExpensesList(mockExpenses)
    }
}