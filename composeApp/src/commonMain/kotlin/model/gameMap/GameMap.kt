package model.gameMap

import kotlinx.serialization.Serializable

@Serializable
data class GameMap (
    val sizeX: Int = 36,
    val sizeY: Int = 24,
    val nodes : List<List<MapNode>> =
        List(sizeY) { y ->
            List(sizeX) { x ->
                MapNode(x = x, y = y)
            }
        }
)