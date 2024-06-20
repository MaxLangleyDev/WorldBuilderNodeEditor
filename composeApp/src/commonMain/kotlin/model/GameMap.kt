package model

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class GameMap (
    val sizeX: Int = 24,
    val sizeY: Int = 24,
    val mapNodes : Array<Array<MapNode>> = Array(sizeX) { Array(sizeY) { MapNode(color = Color(Random.nextInt(), Random.nextInt(), Random.nextInt())) } }
)