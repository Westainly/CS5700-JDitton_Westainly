import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        var shipmentId by remember { mutableStateOf("") }
        val trackedShipments = remember { mutableStateListOf<String>() }
        val shipmentUpdates = remember { mutableStateMapOf<String, String>() }

        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextField(
                    value = shipmentId,
                    onValueChange = { shipmentId = it },
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    label = { Text("Enter Shipment ID") }
                )
                Button(onClick = {
                    if (shipmentId.isNotBlank() && !trackedShipments.contains(shipmentId)) {
                        trackedShipments.add(shipmentId)
                        shipmentUpdates[shipmentId] = ""
                    }
                    shipmentId = ""
                }) {
                    Text("Track Shipment")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            trackedShipments.forEach { id ->
                ShipmentInfoBox(
                    shipmentId = id,
                    onRemove = { trackedShipments.remove(id) },
                    updates = shipmentUpdates[id] ?: ""
                )
            }
        }

        LaunchedEffect(trackedShipments) {
            withContext(Dispatchers.IO) {
                val simulator = TrackingSimulator()
                val updates = mutableListOf<ShipmentUpdate>()

                // Read updates from the file
                File("src/main/kotlin/test.txt").forEachLine { line ->
                    val parts = line.split(",")
                    val updateType = parts[0]
                    val shipmentId = parts[1]
                    val timestamp = parts[2].toLong()
                    val otherInfo = if (parts.size > 3) parts[3] else ""

                    val update = ShipmentUpdate("", "", timestamp, updateType, shipmentId, otherInfo)
                    updates.add(update)
                }

                // Process updates with a delay and collect the status
                updates.forEach { update ->
                    simulator.processUpdate(update)
                    delay(1000) // Simulate one update per second

                    trackedShipments.forEach { id ->
                        val shipment = simulator.findShipment(id)
                        if (shipment != null) {
                            shipmentUpdates[id] = buildString {
                                appendLine("Shipment ID: ${shipment.id}")
                                appendLine("Status: ${shipment.status}")
                                appendLine("Location: ${shipment.currentLocation}")
                                appendLine("Expected Delivery: ${shipment.expectedDeliveryDateTimestamp}")
                                appendLine("Notes: ${shipment.getNotes().joinToString(", ")}")
                                appendLine("Update History: ${shipment.getUpdateHistory().joinToString { "${it.previousStatus} to ${it.newStatus} on ${it.timestamp}" }}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShipmentInfoBox(shipmentId: String, onRemove: () -> Unit, updates: String) {
    Box(modifier = Modifier.fillMaxWidth().padding(8.dp).border(1.dp, Color.Gray)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Shipment ID: $shipmentId", style = MaterialTheme.typography.h6)
                Button(onClick = onRemove) {
                    Text("X")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(updates, style = MaterialTheme.typography.body1)
        }
    }
}
