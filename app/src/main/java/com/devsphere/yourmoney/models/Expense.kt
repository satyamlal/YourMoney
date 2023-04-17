package com.devsphere.yourmoney.models

import java.time.LocalDate

data class Expense(
    val id: Int,
    val amount: Double,
    val recurrence: Recurrence,
    val date: LocalDate,
    val note: String,
    val category: Category,
)

data class DayExpenses(
    val expenses: MutableList<Expense>,
    var total: Double
)

fun List<Expense>.groupedByDay(): Map<LocalDate, DayExpenses> {
    // create the empty map
    val dataMap: MutableMap<LocalDate, DayExpenses> = mutableMapOf()
    // loop through the list
    this.forEach { expense ->
        val date = expense.date

        if(dataMap[date] == null) {
            dataMap[date] = DayExpenses(
                expenses = mutableListOf(),
                total = 0.0
            )
        }
        dataMap[date]?.expenses?.add(expense)
        dataMap[date]?.total?.plus(expense.amount)
    }

    // return the map
    return dataMap.toSortedMap()
}