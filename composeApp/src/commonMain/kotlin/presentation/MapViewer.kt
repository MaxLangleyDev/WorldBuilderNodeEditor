package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.GameMap

@Composable
fun MapViewer(
    modifier: Modifier = Modifier,
    map: GameMap= GameMap()
) {

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).horizontalScroll(rememberScrollState())
    ) {
        for (x in 0..<map.sizeX) {
            Row {
                for (y in 0..<map.sizeY) {
                    Column(
                        modifier = Modifier.padding(3.dp)
                    ){
                        MapNodeView(mapNode = map.mapNodes[x][y])
                    }
                }
            }
        }
    }

}