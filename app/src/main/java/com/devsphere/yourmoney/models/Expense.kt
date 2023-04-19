package com.devsphere.yourmoney.models

import java.time.LocalDate
import java.time.LocalDateTime

data class Expense(
    val id: Int,
    val amount: Double,
    val recurrence: Recurrence,
    val date: LocalDateTime,
    val note: String?,
    val category: Category,
)

data class DayExpenses(
    val expenses: MutableList<Expense>,
    var total: Double
)

fun List<Expense>.groupedByDayOfWeek(): Map<String, DayExpenses> {
    // create the empty map
    val dataMap: MutableMap<String, DayExpenses> = mutableMapOf()
    // loop through the list
    this.forEach { expense ->
        val dayOfWeek = expense.date.toLocalDate().dayOfWeek

        if (dataMap[dayOfWeek.name] == null) {
            dataMap[dayOfWeek.name] = DayExpenses(
                expenses = mutableListOf(),
                total = 0.0
            )
        }
        dataMap[dayOfWeek.name]!!.expenses.add(expense)
        dataMap[dayOfWeek.name]!!.total = dataMap[dayOfWeek.name]!!.total.plus(expense.amount)
    }


    // return the map
    return dataMap.toSortedMap(compareByDescending { it })
}