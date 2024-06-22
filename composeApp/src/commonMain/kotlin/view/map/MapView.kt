package view.map

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import model.GameMap
import model.MapEditorState
import model.MapNode

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    mapEditorState: MapEditorState = MapEditorState(),
) {
    val horizontalScrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()

    var isDragging by remember { mutableStateOf(false) }
    var brushSize by remember { mutableStateOf(32f) }
    var currentDragPosition by remember { mutableStateOf(Offset.Zero) }

    var selectedIndices = remember { mutableStateListOf<Pair<Int, Int>>() }
    val nodePositions = remember { mutableStateListOf<Pair< Pair<Int, Int>, Rect >>() }

    Box(
        modifier = modifier
    ) {
        Column(
            modifier =
            Modifier
                .verticalScroll(verticalScrollState)
                .horizontalScroll(horizontalScrollState)
                .pointerInput(Unit) {
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
                            if (isDragging) {

                                val verticalScrollOffset = verticalScrollState.value.toFloat()
                                val horizontalScrollOffset = horizontalScrollState.value.toFloat()
                                

                                currentDragPosition = change.position

                                val brushTopLeft =
                                    currentDragPosition - Offset(brushSize / 2, brushSize / 2) - Offset(horizontalScrollOffset, verticalScrollOffset)

                                val brushBottomRight = brushTopLeft + Offset(brushSize, brushSize)

                                val brushArea = Rect(
                                    left = brushTopLeft.x,
                                    top = brushTopLeft.y,
                                    right = brushBottomRight.x,
                                    bottom = brushBottomRight.y
                                )

                                selectedIndices.addAll(
                                    nodePositions.filter { (_, rect) ->
                                        brushArea.overlaps(rect)
                                    }.map { it.first }
                                )
                            }
                        }
                    )
                }

        ) {

            // Draw the map nodes
            for (x in 0..<mapEditorState.map.sizeX) {
                Row {
                    for (y in 0..<mapEditorState.map.sizeY) {
                        Column(
                            modifier = Modifier.padding(3.dp)
                        ) {
                            MapNodeView(
                                modifier = Modifier
                                    .size(30.dp)
                                    .onGloballyPositioned {
                                            coordinates ->
                                        
                                        val rect = Rect(
                                            coordinates.positionInRoot().x,
                                            coordinates.positionInRoot().y,
                                            coordinates.positionInRoot().x + coordinates.size.width,
                                            coordinates.positionInRoot().y + coordinates.size.height
                                        )

                                        val newPair = (x to y) to rect

                                        for (pair in nodePositions){

                                            if (pair.first == newPair.first){
                                                nodePositions.remove(pair)
                                                break
                                            }

                                        }

                                        nodePositions.add(newPair)
                                    }
                                    .background(if ((Pair(x, y)) in selectedIndices) Color.Red else Color.Blue),
                                mapNode = mapEditorState.map.nodes[x][y]
                            )
                        }
                    }
                }
            }
        }

        // Render the brush rectangle if dragging
        if (isDragging) {
            val verticalScrollOffset = verticalScrollState.value.toFloat()
            val horizontalScrollOffset = horizontalScrollState.value.toFloat()

            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = Color.Gray.copy(alpha = 0.5f),
                    topLeft = currentDragPosition
                            - Offset(brushSize / 2, brushSize / 2) - Offset(horizontalScrollOffset, verticalScrollOffset),
                    size = Size(brushSize, brushSize),
                    style = Stroke(width = 2.dp.toPx())
                )
            }
        }
    }

}