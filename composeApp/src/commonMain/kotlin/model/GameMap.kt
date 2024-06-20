package model

import kotlinx.serialization.Serializable

@Serializable
data class GameMap (
    val sizeX: Int = 24,
    val sizeY: Int = 24,
    val nodes : List<List<MapNode>> =
        List(sizeX) { x ->
            List(sizeY) { y ->
                MapNode(x = x, y = y)
            }
        }
)