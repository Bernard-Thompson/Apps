package bam.budget.repository

import bam.budget.database.ExpenseDao
import bam.budget.model.Expense
import bam.budget.model.ExpenseCategory
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import java.time.LocalDate


class ExpenseRepository(private val expenseDao: ExpenseDao) {

    // Get all expenses for a user
    fun getAllExpenses(userId: String): Flow<List<Expense>> {
        return expenseDao.getAllExpenses(userId)
    }

    // Get total spending within a given time period
    fun getTotalSpending(userId: String, startDate: LocalDate, endDate: LocalDate): Flow<BigDecimal> {
        return expenseDao.getTotalSpending(userId, startDate, endDate)
    }

    // Get expenses by category
    fun getExpensesByCategory(userId: String, category: ExpenseCategory): Flow<List<Expense>> {
        return expenseDao.getExpensesByCategory(userId, category)
    }

    // Insert a new expense
    suspend fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    // Update an existing expense
    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }

    // Delete an expense
    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }
}