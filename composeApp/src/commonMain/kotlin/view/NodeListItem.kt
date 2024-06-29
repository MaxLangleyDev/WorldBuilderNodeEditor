package view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.gameMap.MapNode

@Composable
fun NodeListItem(
    modifier: Modifier = Modifier,
    mapNode: MapNode = MapNode(),
){

    Column(
        modifier = modifier
    ) {

        Text(
            text = mapNode.name,
        )

        Text(
            text = mapNode.description,
        )

        Text(
            text = mapNode.type,
        )

        Text(
            text = "Coordinates: ${mapNode.x}, ${mapNode.y}",
        )

    }

}