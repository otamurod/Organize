package uz.otamurod.organize.domain

import platform.Foundation.NSUUID

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class UUID actual constructor() {
    private val value = NSUUID()
    actual override fun toString() = value.UUIDString
}