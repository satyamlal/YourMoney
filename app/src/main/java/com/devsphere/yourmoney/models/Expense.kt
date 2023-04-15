package com.devsphere.yourmoney.models

import java.time.LocalDate

data class Expense(
    val amount: Double,
    val recurrence: Recurrence,
    val date: LocalDate,
    val note: String,
    val category: Category,
) {
}