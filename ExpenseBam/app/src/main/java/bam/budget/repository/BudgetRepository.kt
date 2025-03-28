package bam.budget.repository

import bam.budget.database.BudgetDao
import bam.budget.model.Budget
import kotlinx.coroutines.flow.Flow


class BudgetRepository(private val budgetDao: BudgetDao) {

    // Get latest budget for a user
    fun getLatestBudget(userId: String): Flow<Budget?> {
        return budgetDao.getLatestBudget(userId)
    }

    // Get all budgets for a user (history)
    fun getAllBudgets(userId: String): Flow<List<Budget>> {
        return budgetDao.getAllBudgets(userId)
    }

    // Insert a budget
    suspend fun insertBudget(budget: Budget) {
        budgetDao.insertBudget(budget)
    }

    // Update an existing budget
    suspend fun updateBudget(budget: Budget) {
        budgetDao.updateBudget(budget)
    }

    // Delete a budget
    suspend fun deleteBudget(budget: Budget) {
        budgetDao.deleteBudget(budget)
    }

}