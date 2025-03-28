package bam.budget

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import bam.budget.model.Budget
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class BudgetDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: BudgetDatabase
    private lateinit var budgetDao: BudgetDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BudgetDatabase::class.java
        ).allowMainThreadQueries().build()
        budgetDao = database.budgetDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertBudgetAndRetrieveLatest() = runTest {
        val budget = Budget(
            userId = "user123",
            totalIncome = 5000.0,
            rent = 1000.0,
            healthcare = 200.0,
            car = 300.0,
            carInsurance = 100.0,
            gasUpkeep = 50.0,
            publicTransport = 30.0,
            daycare = 400.0,
            childExpenses = 150.0,
            haircuts = 20.0,
            internet = 60.0,
            phoneH = 40.0,
            phoneC = 50.0,
            laundry = 25.0,
            utilities = 150.0,
            grocery = 500.0,
            spendingCash = 200.0,
            contingency = 500.0,
            savings = 250.0,
            trackingPeriod = "monthly"
        )

        budgetDao.insertBudget(budget)
        val latestBudget = budgetDao.getLatestBudget("user123").first()

        Assert.assertNotNull(latestBudget)
        Assert.assertEquals(5000.0, latestBudget?.totalIncome, 0.0)
    }

    @Test
    fun updateBudgetAndVerifyChange() = runTest {
        val budget = Budget(userId = "user123", totalIncome = 4000.0, rent = 1000.0, healthcare = 200.0, car = 300.0, carInsurance = 100.0, gasUpkeep = 50.0, publicTransport = 30.0, daycare = 400.0, childExpenses = 150.0, haircuts = 20.0, internet = 60.0, phoneH = 40.0, phoneC = 50.0, laundry = 25.0, utilities = 150.0, grocery = 500.0, spendingCash = 200.0, contingency = 400.0, savings = 200.0, trackingPeriod = "monthly")

        budgetDao.insertBudget(budget)

        val updatedBudget = budget.copy(totalIncome = 4500.0)
        budgetDao.updateBudget(updatedBudget)

        val latestBudget = budgetDao.getLatestBudget("user123").first()

        Assert.assertEquals(4500.0, latestBudget?.totalIncome, 0.0)
    }

    @Test
    fun deleteBudgetAndVerify() = runTest {
        val budget = Budget(userId = "user123", totalIncome = 5000.0, rent = 1000.0, healthcare = 200.0, car = 300.0, carInsurance = 100.0, gasUpkeep = 50.0, publicTransport = 30.0, daycare = 400.0, childExpenses = 150.0, haircuts = 20.0, internet = 60.0, phoneH = 40.0, phoneC = 50.0, laundry = 25.0, utilities = 150.0, grocery = 500.0, spendingCash = 200.0, contingency = 500.0, savings = 250.0, trackingPeriod = "monthly")

        budgetDao.insertBudget(budget)
        budgetDao.deleteBudget(budget)

        val latestBudget = budgetDao.getLatestBudget("user123").first()

        Assert.assertNull(latestBudget)
    }

}