package model

import kotlinx.serialization.Serializable
import model.gameMap.GameMap
import model.gameMap.MapNode

@Serializable
data class MapEditorState(
    val map: GameMap = GameMap(),
    val selectedNodes: List<MapNode>? = null
)
