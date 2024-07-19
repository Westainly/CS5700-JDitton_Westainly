import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import java.util.*

@Composable
@Preview
fun App() {
    var shipmentIdSearch by remember { mutableStateOf("")}
    val shipments = remember { mutableStateListOf<TrackerViewHelper>()}

    MaterialTheme {
        Column {
            Row {
                TextField(
                    value = shipmentIdSearch,
                    onValueChange = { shipmentIdSearch = it},
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f))

                Button(onClick = {
                    TrackingSimulator.findShipment(shipmentIdSearch)?.let { TrackerViewHelper(it) }
                        ?.let { shipments.add(it) }
                    shipmentIdSearch = ""
                },
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text("Search")
                }
            }
            LazyColumn {
                items(shipments, key = {it.shipmentID}) {
                    Column (modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                        ){
                        Text("Tracking shipment: ${it.shipmentID}")
                        Text("Status: ${it.shipmentStatus}")
                        Text("Location: ${it.shipmentLocation}")
                        Text("Expected Delivery: ${Date(it.shipmentExpectedDelivery)}")
                        Spacer(modifier = Modifier
                            .padding(8.dp))
                        Text("Status Updates:")
                        it.shipmentUpdateHistory.forEach{ update ->
                            Text("Shipment went from ${update.previousStatus} to ${update.newStatus} at ${Date(update.timeStamp)}")
                        }
                        Spacer(modifier = Modifier
                            .padding(4.dp))
                        Text("Notes:")
                        it.shipmentNotes.forEach{ note ->
                            Text(note)
                        }
                        Button(onClick = {
                            it.unsub()
                            shipments.remove(it)
                        }){
                            Text("Stop Tracking")
                        }
                    }
                }
            }
        }
    }
}

fun main() =  application {
    val coroutineScope = rememberCoroutineScope()
    Window(onCloseRequest = ::exitApplication) {
        App()
    }

    coroutineScope.launch {
        TrackingSimulator.runSimulation()
    }
}
