package uz.otamurod.organize

expect object DateFormatter {
    fun formatEpoch(epoch: Long): String
}