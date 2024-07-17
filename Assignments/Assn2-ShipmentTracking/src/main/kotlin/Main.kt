import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.*
import java.io.File

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            var shipmentUpdates by remember { mutableStateOf("") }

            LaunchedEffect(Unit) {
                shipmentUpdates = runSimulation()
            }

            Text(shipmentUpdates)
        }
    }
}

suspend fun runSimulation(): String {
    val simulator = TrackingSimulator()
    val updates = mutableListOf<ShipmentUpdate>()

    // Read updates from the file
    withContext(Dispatchers.IO) {
        File("src/main/kotlin/test.txt").forEachLine { line ->
            val parts = line.split(",")
            val updateType = parts[0]
            val shipmentId = parts[1]
            val timestamp = parts[2].toLong()
            val otherInfo = if (parts.size > 3) parts[3] else ""

            println(parts)

            val update = ShipmentUpdate("", "", timestamp, updateType, shipmentId, otherInfo)
            updates.add(update)
            println(update)
        }
    }

    // Process updates with a delay and collect the status
    val statusBuilder = StringBuilder()
    updates.forEach { update ->
        simulator.processUpdate(update)
        delay(100) // Simulate one update per second

        val shipment = simulator.findShipment(update.shipmentId)
        if (shipment != null) {
            statusBuilder.appendLine("Shipment ID: ${shipment.id}")
            statusBuilder.appendLine("Status: ${shipment.status}")
            statusBuilder.appendLine("Location: ${shipment.currentLocation}")
            statusBuilder.appendLine("Expected Delivery: ${shipment.expectedDeliveryDateTimestamp}")
            statusBuilder.appendLine("Notes: ${shipment.getNotes().joinToString(", ")}")
            statusBuilder.appendLine("Update History: ${shipment.getUpdateHistory().joinToString { "${it.previousStatus} to ${it.newStatus} on ${it.timestamp}" }}")
            statusBuilder.appendLine()
        }
    }

    return statusBuilder.toString()
}
