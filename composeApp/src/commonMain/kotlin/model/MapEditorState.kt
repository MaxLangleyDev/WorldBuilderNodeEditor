package model

import kotlinx.serialization.Serializable

@Serializable
data class MapEditorState(
    val map: GameMap = GameMap(),
    val selectedNodes: List<MapNode>? = null
)
