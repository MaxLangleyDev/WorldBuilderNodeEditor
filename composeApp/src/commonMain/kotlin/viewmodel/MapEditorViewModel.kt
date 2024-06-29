package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.MapEditorState
import model.gameMap.MapNode

class MapEditorViewModel(
    initialState: MapEditorState = MapEditorState()
): ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    fun addSelectedNode(node: MapNode){

        val selectedNodes = _state.value.selectedNodes?.toMutableList() ?: mutableListOf()
        selectedNodes.add(node)
        _state.update {
            it.copy(selectedNodes = selectedNodes.toSet().toList())
        }
        _state.value = _state.value.copy(selectedNodes = selectedNodes)

    }

}