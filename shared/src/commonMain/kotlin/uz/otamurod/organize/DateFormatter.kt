package uz.otamurod.organize

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object DateFormatter {
    fun formatEpoch(epoch: Long): String
}