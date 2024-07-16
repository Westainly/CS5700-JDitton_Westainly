import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val trackingSimulator = TrackingSimulatorObserver()

    // Initialize the simulator with some data or from a file
    // For example:
    // trackingSimulator.runSimulation(listOf(
    //     ShipmentUpdate("created", "1243234", 1999283774),
    //     ShipmentUpdate("shipped", "1243234", 1999437478, "19999488398")
    // ))

    UserInterface(trackingSimulator = trackingSimulator)
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
