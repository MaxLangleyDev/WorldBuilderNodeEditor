package view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import view.map.MapView
import viewmodel.MapEditorViewModel

@Composable
fun EditorScreen(
    modifier: Modifier = Modifier
){
    val viewModel = viewModel { MapEditorViewModel() }
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier
    ){
        Row(
            modifier.weight(0.7f).fillMaxWidth()
        ){
            MapView(
                modifier = Modifier.weight(0.7f),
                mapEditorState = state,
                onAddSelectedNode = viewModel::addSelectedNode
            )

            NodeEditor(
                modifier = Modifier.weight(0.3f),
                gameMap = state.map,
                selectedNodes = state.selectedNodes ?: emptyList()
            )
        }

    }

}