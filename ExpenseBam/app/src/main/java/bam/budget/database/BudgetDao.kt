package bam.budget.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import bam.budget.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    // Insert a new budget plan (replace if it exists for the user)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: Budget)

    // Update an existing budget entry
    @Update
    suspend fun updateBudget(budget: Budget)

    // Delete a budget entry
    @Delete
    suspend fun deleteBudget(budget: Budget)

    // Get the latest budget plan for a user (Assuming one budget per user)
    @Query("SELECT * FROM budget_table WHERE userId = :userId ORDER BY id DESC LIMIT 1")
    fun getLatestBudget(userId: String): Flow<Budget?>

    // Get all budgets for a user (history)
    @Query("SELECT * FROM budget_table WHERE userId = :userId ORDER BY id DESC")
    fun getAllBudgets(userId: String): Flow<List<Budget>>
}