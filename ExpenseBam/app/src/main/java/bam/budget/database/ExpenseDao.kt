package bam.budget.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import bam.budget.model.Expense
import bam.budget.model.ExpenseCategory
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import java.time.LocalDate


@Dao
interface ExpenseDao {

    // Insert a new expense entry
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    // Update an existing expense entry
    @Update
    suspend fun updateExpense(expense: Expense)

    // Delete an expense entry
    @Delete
    suspend fun deleteExpense(expense: Expense)

    // Get all expenses for a user
    @Query("SELECT * FROM expenses WHERE userId = :userId ORDER BY date DESC")
    fun getAllExpenses(userId: String): Flow<List<Expense>>

    // Get total spending for a user within a given period
    @Query("SELECT SUM(amountSpent) FROM expenses WHERE userId = :userId AND date >= :startDate AND date <= :endDate")
    fun getTotalSpending(userId: String, startDate: LocalDate, endDate: LocalDate): Flow<BigDecimal>

    // Get expenses by category
    @Query("SELECT * FROM expenses WHERE userId = :userId AND category = :category ORDER BY date DESC")
    fun getExpensesByCategory(userId: String, category: ExpenseCategory): Flow<List<Expense>>
}