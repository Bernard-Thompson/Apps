package bam.budget.database

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import bam.budget.R

fun sendOverspendingAlert(context: Context, category: String, amount: Double) {
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val notification = NotificationCompat.Builder(context, "BUDGET_ALERTS")
        .setContentTitle("Overspending Alert!")
        .setContentText("You overspent on $category by $$amount!")
        .setSmallIcon(R.drawable.ic_alert)
        .build()
    notificationManager.notify(1, notification)
}