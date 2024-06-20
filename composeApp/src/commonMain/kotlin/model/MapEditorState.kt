package model

data class MapEditorState(
    val map: GameMap = GameMap(),
    val selectedNodes: List<MapNode>? = null
)
