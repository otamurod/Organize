package uz.otamurod.organize.presentation

import uz.otamurod.organize.Platform
import kotlin.math.max
import kotlin.math.min

class AboutViewModel(
    platform: Platform
) : BaseViewModel() {
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
