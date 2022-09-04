import androidx.compose.ui.window.Window
import com.yt8492.todompp.ui.TodoRootView
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    val root = document.getElementById("root")!!
    val canvas = document.getElementById("ComposeTarget")!!
    canvas.setAttribute("width", root.clientWidth.toString())
    canvas.setAttribute("height", root.clientHeight.toString())
    onWasmReady {
        Window {
            TodoRootView()
        }
    }
}