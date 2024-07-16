import androidx.compose.runtime.mutableStateOf

class TrackerViewHelper {
    val shipmentId = mutableStateOf("")
    val shipmentNotes = mutableStateOf<List<String>>(emptyList())
    val shipmentUpdateHistory = mutableStateOf<List<String>>(emptyList())
    val expectedShipmentDeliveryDate = mutableStateOf("")
    val shipmentStatus = mutableStateOf("")

    fun trackShipment(id: String, simulator: TrackingSimulator) {
        val shipment = simulator.findShipment(id)
        if (shipment != null) {
            shipmentId.value = shipment.id
            shipmentNotes.value = shipment.getNotes()
            shipmentUpdateHistory.value = shipment.getUpdateHistory().map { update ->
                "Shipment went from ${update.previousStatus} to ${update.newStatus} on ${update.timestamp}"
            }
            expectedShipmentDeliveryDate.value = shipment.expectedDeliveryDateTimestamp?.toString() ?: "N/A"
            shipmentStatus.value = shipment.status
        } else {
            // Notify user that the shipment doesn't exist
        }
    }

    fun stopTracking() {
        // Logic to stop tracking the current shipment
    }
}