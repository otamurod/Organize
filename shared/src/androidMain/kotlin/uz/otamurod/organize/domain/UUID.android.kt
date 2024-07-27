package uz.otamurod.organize.domain

import java.util.UUID

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class UUID actual constructor() {
    private val value: UUID = UUID.randomUUID()
    actual override fun toString() = value.toString()
}