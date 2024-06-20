package presentation.map

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import model.GameMap

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    map: GameMap= GameMap()
) {
    var isDragging by remember { mutableStateOf(false) }
    var brushSize by remember { mutableStateOf(32f) }
    var currentDragPosition by remember { mutableStateOf(Offset.Zero) }

    Column(
        modifier =
        modifier
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
            .pointerInput(Unit){
                detectDragGestures(
                    onDragStart = { offset ->
                        isDragging = true
                        currentDragPosition = offset
                    },
                    onDragEnd = {
                        isDragging = false
                    },
                    onDragCancel = {
                        isDragging = false
                    },
                    onDrag = { change, _ ->
                        if (isDragging) {// Update selected nodes based on current pointer position
                            // Calculate the brush area
                            currentDragPosition = change.position
                            val brushTopLeft = currentDragPosition - Offset(brushSize / 2, brushSize / 2)
                            val brushBottomRight = brushTopLeft + Offset(brushSize, brushSize)
                            val brushArea = Rect(
                                left = brushTopLeft.x,
                                top = brushTopLeft.y,
                                right = brushBottomRight.x,
                                bottom= brushBottomRight.y
                            )

                            // Update selected nodes based on the brush area
//                            selectedNodes = nodes.filter { node ->
//                                brushArea.contains(node.position)
//                            }
                        }
                    }
                )
            }
            .clipToBounds()
    ) {

        // Draw the map nodes
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

    // Render the brush rectangle if dragging
    if (isDragging) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = Color.Gray.copy(alpha = 0.5f),
                topLeft = currentDragPosition - Offset(brushSize / 2, brushSize / 2),
                size = Size(brushSize, brushSize),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }

}