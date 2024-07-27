@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package uz.otamurod.organize


import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

actual object DateFormatter {
    actual fun formatEpoch(epoch: Long): String {
        val date = Date(epoch * 1000)
        return SimpleDateFormat
            .getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT)
            .format(date)
    }
}