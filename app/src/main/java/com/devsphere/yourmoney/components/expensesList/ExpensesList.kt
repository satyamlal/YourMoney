package com.devsphere.yourmoney.components.expensesList

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.groupedByDayOfWeek
import com.devsphere.yourmoney.ui.theme.YourMoneyTheme
import java.time.LocalDate

@Composable
fun ExpensesList(expenses: List<Expense>, modifier: Modifier = Modifier) {
    val groupedExpenses = expenses.groupedByDayOfWeek()

    Column(modifier = modifier) {
        groupedExpenses.keys.forEach() { date ->
            if(groupedExpenses[date] != null) {
                ExpensesDayGroup(date = LocalDate.now(),
                    dayExpenses = groupedExpenses[date]!!, modifier = Modifier.padding(16.dp))
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