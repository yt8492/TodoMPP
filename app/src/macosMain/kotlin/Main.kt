import androidx.compose.ui.window.Window
import com.yt8492.todompp.ui.Root
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

fun main() {
    NSApplication.sharedApplication()
    Window("TodoMPP") {
        Root()
    }
    NSApp?.run()
}
