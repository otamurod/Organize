package uz.otamurod.organize.domain

import java.util.UUID

actual class UUID actual constructor() {
    private val value: UUID = UUID.randomUUID()
    actual override fun toString() = value.toString()
}