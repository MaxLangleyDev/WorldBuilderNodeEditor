package model

import kotlinx.serialization.Serializable

@Serializable
data class GameEvent(
    val name: String,
)
