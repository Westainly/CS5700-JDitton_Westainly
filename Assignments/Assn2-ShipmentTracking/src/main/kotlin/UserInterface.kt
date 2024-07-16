import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun UserInterface(trackingSimulator: TrackingSimulatorObserver) {
    val viewHelper = remember { TrackerViewHelper() }
    val shipmentId by viewHelper.shipmentId
    val shipmentNotes by viewHelper.shipmentNotes
    val shipmentUpdateHistory by viewHelper.shipmentUpdateHistory
    val expectedShipmentDeliveryDate by viewHelper.expectedShipmentDeliveryDate
    val shipmentStatus by viewHelper.shipmentStatus

    LaunchedEffect(Unit) {
        trackingSimulator.addObserver(viewHelper)
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = shipmentId,
            onValueChange = { viewHelper.shipmentId.value = it },
            label = { Text("Shipment ID") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                scope.launch {
                    viewHelper.trackShipment(shipmentId, trackingSimulator)
                }
            }) {
                Text("Track Shipment")
            }

            Button(onClick = {
                viewHelper.stopTracking()
            }) {
                Text("Stop Tracking")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Shipment Status: $shipmentStatus")
        Text("Expected Delivery: $expectedShipmentDeliveryDate")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Notes:")
        shipmentNotes.forEach { note ->
            Text("- $note")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Update History:")
        shipmentUpdateHistory.forEach { update ->
            Text("- $update")
        }
    }
}
