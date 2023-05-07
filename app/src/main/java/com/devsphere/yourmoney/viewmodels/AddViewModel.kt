package com.devsphere.yourmoney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsphere.yourmoney.db
import com.devsphere.yourmoney.models.Category
import com.devsphere.yourmoney.models.Recurrence
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

data class AddScreenState(
    val amount: String = "",
    val recurrence: Recurrence = Recurrence.None,
    val date: LocalDate = LocalDate.now(),
    val note: String = "",
    val category: Category? = null,
    val categories: RealmResults<Category>? = null
)

class AddViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddScreenState())
    val uiState: StateFlow<AddScreenState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                categories = db.query<Category>().find()
            )
        }
    }

    fun setAmount(amount: String) {
        _uiState.update { currentState ->
            currentState.copy(
                amount = amount.trim(),
            )
        }
    }

    fun setRecurrence(recurrence: Recurrence) {
        _uiState.update { currentState ->
            currentState.copy(
                recurrence = recurrence,
            )
        }
    }

    fun setDate(date: LocalDate) {
        _uiState.update { currentState ->
            currentState.copy(
                date = date,
            )
        }
    }

    fun setNote(note: String) {
        _uiState.update { currentState ->
            currentState.copy(
                note = note,
            )
        }
    }

    fun setCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                category = category,
            )
        }
    }

    fun submitExpense() {
        // TODO: save to local db
    }
}

