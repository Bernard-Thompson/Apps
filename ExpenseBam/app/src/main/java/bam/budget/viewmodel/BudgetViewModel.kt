package bam.budget.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bam.budget.model.Budget
import bam.budget.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class BudgetViewModel(private val repository: BudgetRepository) : ViewModel() {
    val allBudgets: Flow<List<Budget>> = repository.allBudgets

    fun addBudget(budget: Budget) {
        viewModelScope.launch { repository.insertBudget(budget) }
    }

    fun updateBudget(budget: Budget) {
        viewModelScope.launch { repository.updateBudget(budget) }
    }
}