import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.GameMap
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        val map = GameMap()

        Column {
            for (x in 0..<map.sizeX) {
                Row {
                    for (y in 0..<map.sizeY) {
                        Column(
                            modifier = Modifier.padding(3.dp)
                        ){
                            Box(
                                modifier = Modifier.size(30.dp)
                                    .background(map.mapNodes[x][y].color)

                            )
                        }
                    }
                }
            }
        }

    }
}