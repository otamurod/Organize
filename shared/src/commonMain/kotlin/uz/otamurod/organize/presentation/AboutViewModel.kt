package uz.otamurod.organize.presentation

import com.russhwolf.settings.Settings
import kotlinx.datetime.Clock
import uz.otamurod.organize.DateFormatter
import uz.otamurod.organize.Platform
import kotlin.math.max
import kotlin.math.min

class AboutViewModel(
    platform: Platform,
    settings: Settings
) : BaseViewModel() {
    val firstOpening: String
    
    init {
        val timestampKey = "FIRST_OPENING_TIMESTAMP"
        
        val savedValue = settings.getLongOrNull(timestampKey)
        
        firstOpening = if (savedValue == null) {
            val time = Clock.System.now().epochSeconds - 1
            settings.putLong(timestampKey, time)
            
            DateFormatter.formatEpoch(time)
        } else {
            DateFormatter.formatEpoch(savedValue)
        }
    }
    
    val items: List<RowItem> = makeRowItems(platform)
    
    private fun makeRowItems(platform: Platform): List<RowItem> {
        val rowItems = mutableListOf(
            RowItem("Operating System", "${platform.osName} ${platform.osVersion}"),
            RowItem("Device", platform.deviceModel),
            RowItem("CPU", platform.cpuType),
        )
        
        val max = max(platform.screen.width, platform.screen.height)
        val min = min(platform.screen.width, platform.screen.height)
        
        var displayInfo = "${max}×${min}"
        platform.screen.density?.let {
            displayInfo += " ${it}x"
        }
        
        rowItems.add(
            RowItem("Display", displayInfo)
        )
        
        return rowItems
    }
    
    data class RowItem(
        val title: String,
        val subtitle: String
    )
}
