package view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.gameMap.GameMap
import model.gameMap.MapNode

@Composable
fun NodeEditor(
    modifier: Modifier = Modifier,
    gameMap: GameMap = GameMap(),
    selectedNodes: List<MapNode> = emptyList()
){

    Column(
        modifier = modifier
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.weight(1f)
        ){
            items(selectedNodes){
                NodeListItem(
                    mapNode = it
                )
            }
        }
    }

}