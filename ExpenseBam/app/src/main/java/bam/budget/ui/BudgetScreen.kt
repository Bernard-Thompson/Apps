package bam.budget.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bam.budget.viewmodel.BudgetViewModel


@Composable
fun BudgetScreen(viewModel: BudgetViewModel = viewModel()) {
    val budgets by viewModel.allBudgets.collectAsState(emptyList())

    Column(Modifier.padding(16.dp)) {
        budgets.forEach { budget ->
            Card(Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp) {
                Column(Modifier.padding(8.dp)) {
                    Text(text = budget.category, style = MaterialTheme.typography.h6)
                    Text(text = "Allocated: ${budget.allocatedAmount}")
                    Text(text = "Spent: ${budget.spentAmount}")
                }
            }
        }
    }
}