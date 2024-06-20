package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.MapEditorState

class MapEditorViewModel(
    initialState: MapEditorState = MapEditorState()
): ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

}