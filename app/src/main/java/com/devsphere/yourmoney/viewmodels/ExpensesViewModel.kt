package com.devsphere.yourmoney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsphere.yourmoney.components.mock.mockExpenses
import com.devsphere.yourmoney.models.Expense
import com.devsphere.yourmoney.models.Recurrence
import com.devsphere.yourmoney.utils.calculateDateRange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExpensesState(
    val recurrence: Recurrence = Recurrence.Daily,
    val sumTotal: Double = 1250.68,
    val expenses: List<Expense> = mockExpenses
)

class ExpensesViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ExpensesState())
    val uiState: StateFlow<ExpensesState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                expenses = mockExpenses
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            setRecurrence(Recurrence.Daily)
        }
    }

    fun setRecurrence(recurrence: Recurrence) {
        val (start, end, daysInRange) = calculateDateRange(recurrence, 0)

        val filteredExpenses = mockExpenses.filter { expense ->
            (expense.date.toLocalDate().isAfter(start) && expense.date.toLocalDate()
                .isBefore(end)) || expense.date.toLocalDate()
                .isEqual(start) || expense.date.toLocalDate().isEqual(end)
        }

        val sumTotal = filteredExpenses.sumOf { it.amount }

        _uiState.update { currentState ->
            currentState.copy(
                recurrence = recurrence,
                expenses = filteredExpenses,
                sumTotal = sumTotal
            )
        }
    }
}