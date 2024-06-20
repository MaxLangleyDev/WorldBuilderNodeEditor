import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import view.EditorScreen
import view.map.MapView
import theme.MapEditorTheme

@Composable
@Preview
fun App() {
    MapEditorTheme {

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

            EditorScreen(modifier = Modifier.fillMaxSize())

        }
    }
}