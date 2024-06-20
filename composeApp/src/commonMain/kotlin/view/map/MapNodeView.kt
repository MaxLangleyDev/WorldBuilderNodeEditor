package view.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.MapNode

@Composable
fun MapNodeView(
    modifier: Modifier = Modifier.size(30.dp),
    mapNode: MapNode
){
    Box(
        modifier = modifier
            .background(Color(mapNode.colorHex))
    )
}