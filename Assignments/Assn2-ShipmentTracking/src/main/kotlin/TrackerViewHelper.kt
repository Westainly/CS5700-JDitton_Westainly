import androidx.compose.runtime.mutableStateOf

class TrackerViewHelper : TrackingObserver {
    val shipmentId = mutableStateOf("")
    val shipmentNotes = mutableStateOf<List<String>>(emptyList())
    val shipmentUpdateHistory = mutableStateOf<List<String>>(emptyList())
    val expectedShipmentDeliveryDate = mutableStateOf("")
    val shipmentStatus = mutableStateOf("")

    override fun onShipmentUpdate(shipment: Shipment) {
        if (shipment.id == shipmentId.value) {
            shipmentNotes.value = shipment.getNotes()
            shipmentUpdateHistory.value = shipment.getUpdateHistory().map { update ->
                "Shipment went from ${update.updateType} to ${shipment.status} on ${update.timestamp}"
            }
            expectedShipmentDeliveryDate.value = shipment.expectedDeliveryDateTimestamp?.toString() ?: "N/A"
            shipmentStatus.value = shipment.status
        }
    }

    fun trackShipment(id: String, simulator: TrackingSimulator) {
        val shipment = simulator.findShipment(id)
        if (shipment != null) {
            shipmentId.value = shipment.id
            onShipmentUpdate(shipment)
        } else {
            shipmentStatus.value = "Shipment not found"
        }
    }

    fun stopTracking() {
        shipmentId.value = ""
        shipmentNotes.value = emptyList()
        shipmentUpdateHistory.value = emptyList()
        expectedShipmentDeliveryDate.value = ""
        shipmentStatus.value = ""
    }
}
