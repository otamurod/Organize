package uz.otamurod.organize

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDateFormatterFullStyle
import platform.Foundation.NSDateFormatterShortStyle
import platform.Foundation.NSFormattingContextStandalone
import platform.Foundation.dateWithTimeIntervalSince1970

actual object DateFormatter {
    private val sharedFormatter = NSDateFormatter()
    
    init {
        sharedFormatter.dateStyle = NSDateFormatterFullStyle
        sharedFormatter.timeStyle = NSDateFormatterShortStyle
        sharedFormatter.formattingContext = NSFormattingContextStandalone
    }
    
    actual fun formatEpoch(epoch: Long): String {
        return sharedFormatter.stringFromDate(
            NSDate.dateWithTimeIntervalSince1970(epoch.toDouble())
        )
    }
}