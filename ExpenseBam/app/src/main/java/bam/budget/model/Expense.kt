package bam.budget.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDate

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val category: ExpenseCategory,
    val amountSpent: BigDecimal,
    val date: LocalDate = LocalDate.now()
)