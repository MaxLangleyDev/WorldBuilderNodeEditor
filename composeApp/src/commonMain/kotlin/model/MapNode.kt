package model

import kotlinx.serialization.Serializable

@Serializable
data class MapNode(
    val name: String = "",
    val x: Int = 0,
    val y: Int = 0,
    val traversable: Boolean = false,
    val colorHex: Int = 0xFF000000.toInt(),
)