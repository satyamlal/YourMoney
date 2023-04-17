package com.devsphere.yourmoney.components.expensesList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devsphere.yourmoney.models.DayExpenses
import com.devsphere.yourmoney.utils.formatDay
import java.time.LocalDate

@Composable
fun ExpensesDayGroup(date: LocalDate, dayExpenses: DayExpenses, modifier: Modifier = Modifier) {
    Column() {
        Text(date.formatDay())
    }
}