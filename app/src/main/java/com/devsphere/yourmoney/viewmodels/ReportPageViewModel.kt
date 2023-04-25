package com.devsphere.yourmoney.viewmodels

import androidx.lifecycle.ViewModel
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.YearMonth

data class State(
    val expenses: List<Expense> = listOf(),
    val dateStart: LocalDateTime = LocalDateTime.now(),
    val dateEnd: LocalDateTime = LocalDateTime.now(),
)

class ReportPageViewModel(private val page: Int, val recurrence: Recurrence) : ViewModel() {
    private val _uiState = MutableStateFlow(State())
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    init {
        val today = LocalDate.now()
        when (recurrence) {
            Recurrence.Weekly -> {
                val start = LocalDate.now().minusDays(today.dayOfWeek.value.toLong() - 1)
                    .minusDays((page * 7).toLong())
                val end = start.plusDays(6)

                _uiState.update { currentState ->
                    currentState.copy(
                        dateStart = LocalDateTime.of(start, LocalTime.MIN),
                        dateEnd = LocalDateTime.of(end, LocalTime.MAX),
                    )
                }
            }

            Recurrence.Monthly -> {
                val start = LocalDate.of(today.year, today.month, 1).minusMonths(page.toLong())
                val numberOfDays = YearMonth.of(start.year, start.month).lengthOfMonth()
                val end = start.plusDays(numberOfDays.toLong())

                _uiState.update { currentState ->
                    currentState.copy(
                        dateStart = LocalDateTime.of(start, LocalTime.MIN),
                        dateEnd = LocalDateTime.of(end, LocalTime.MAX),
                    )
                }
            }

            Recurrence.Yearly -> {
                val start = LocalDate.of(today.year, 1, 1)
                val end = LocalDate.of(today.year, 12, 31)

                _uiState.update { currentState ->
                    currentState.copy(
                        dateStart = LocalDateTime.of(start, LocalTime.MIN),
                        dateEnd = LocalDateTime.of(end, LocalTime.MAX),
                    )
                }
            }

            else -> Unit
        }
    }

}