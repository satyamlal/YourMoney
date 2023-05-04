package com.devsphere.yourmoney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.Recurrence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.YearMonth
import java.time.chrono.ChronoLocalDateTime

data class State(
    val expenses: List<Expense> = mockExpenses,
    val dateStart: LocalDateTime = LocalDateTime.now(),
    val dateEnd: LocalDateTime = LocalDateTime.now(),
    val avgPerDay: Double = 0.0,
    val totalInRange: Double = 0.0
)

class ReportPageViewModel(private val page: Int, val recurrence: Recurrence) : ViewModel() {
    private val _uiState = MutableStateFlow(State())
    val uiState: StateFlow<State> = _uiState.asStateFlow()
    private lateinit var start: LocalDate
    private lateinit var end: LocalDate

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val today = LocalDate.now()
            when (recurrence) {
                Recurrence.Weekly -> {
                    start = LocalDate.now().minusDays(today.dayOfWeek.value.toLong() - 1)
                        .minusDays((page * 7).toLong())
                    end = start.plusDays(6)
                }

                Recurrence.Monthly -> {
                    start = LocalDate.of(today.year, today.month, 1)
                        .minusMonths(page.toLong())
                    val numberOfDays = YearMonth.of(start.year, start.month).lengthOfMonth()
                    end = start.plusDays(numberOfDays.toLong())

                }

                Recurrence.Yearly -> {
                    start = LocalDate.of(today.year, 1, 1)
                    end = LocalDate.of(today.year, 12, 31)
                }

                else -> Unit
            }

            val a = LocalDate.of(2012, 6, 30)
            val b = LocalDate.of(2012, 6, 30)

            val isAfter = a.isAfter(b)
            val isBefore = a.isBefore(b)

            val filteredExpenses = mockExpenses.filter { expense ->
                (expense.date.toLocalDate().isAfter(start) && expense.date.toLocalDate()
                    .isBefore(end)) || expense.date.toLocalDate()
                    .isEqual(start) || expense.date.toLocalDate().isEqual(end)
            }

            viewModelScope.launch(Dispatchers.Main) {
                _uiState.update { currentState ->
                    currentState.copy(
                        dateStart = LocalDateTime.of(start, LocalTime.MIN),
                        dateEnd = LocalDateTime.of(end, LocalTime.MAX),
                        expenses = filteredExpenses
                    )
                }
            }
        }
    }
}