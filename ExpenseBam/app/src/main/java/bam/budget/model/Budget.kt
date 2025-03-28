package bam.budget.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "budget_table")
data class Budget(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val totalIncome: BigDecimal,
    val rent: BigDecimal = BigDecimal.ZERO,
    val healthcare: BigDecimal = BigDecimal.ZERO,
    val car: BigDecimal = BigDecimal.ZERO,
    val carInsurance: BigDecimal = BigDecimal.ZERO,
    val gasUpkeep: BigDecimal = BigDecimal.ZERO,
    val publicTransport: BigDecimal = BigDecimal.ZERO,
    val daycare: BigDecimal = BigDecimal.ZERO,
    val childExpenses: BigDecimal = BigDecimal.ZERO,
    val haircuts: BigDecimal = BigDecimal.ZERO,
    val internet: BigDecimal = BigDecimal.ZERO,
    val phoneH: BigDecimal = BigDecimal.ZERO,
    val phoneC: BigDecimal = BigDecimal.ZERO,
    val laundry: BigDecimal = BigDecimal.ZERO,
    val utilities: BigDecimal = BigDecimal.ZERO,
    val grocery: BigDecimal = BigDecimal.ZERO,
    val spendingCash: BigDecimal = BigDecimal.ZERO,
    val contingency: BigDecimal = BigDecimal.ZERO,
    val savings: BigDecimal = BigDecimal.ZERO,
    val trackingPeriod: TrackingPeriod // weekly, bi-weekly, monthly
) {

}