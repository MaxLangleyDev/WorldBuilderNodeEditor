package model

import kotlinx.serialization.Serializable

@Serializable
data class MapNode(
    val name: String = "",
    val type: String = "",
    val description: String = "",

    val x: Int = 0,
    val y: Int = 0,

    val traversableFrom: Map<String, Boolean> = mapOf(
        "n" to true,
        "s" to true,
        "e" to true,
        "w" to true,
    ),
    val traversableTo: Map<String, Boolean> = mapOf(
        "n" to true,
        "s" to true,
        "e" to true,
        "w" to true,
    ),

    val events: List<GameEvent> = emptyList(),

    

    val colorHex: Int = 0xFF000000.toInt(),
)