import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.MapEditorTheme
import view.EditorScreen

@Composable
@Preview
fun App() {
    MapEditorTheme {

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

            EditorScreen(modifier = Modifier.fillMaxSize())

        }
    }
}