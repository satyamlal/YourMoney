package com.devsphere.yourmoney.viewmodels

import androidx.lifecycle.ViewModel
import com.devsphere.yourmoney.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ExpensesState(
    val recurrence: Recurrence = Recurrence.Daily,
)

class ExpensesViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ExpensesState())
    val uiState: StateFlow<ExpensesState> = _uiState.asStateFlow()

    fun setRecurrence(recurrence: Recurrence) {
        _uiState.update { currentState ->
            currentState.copy(
                recurrence = recurrence
            )
        }
    }
}