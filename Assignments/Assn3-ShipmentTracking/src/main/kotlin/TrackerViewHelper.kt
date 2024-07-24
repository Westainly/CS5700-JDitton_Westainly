import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TrackerViewHelper(
    private var shipment: Shipment
): ShipmentObserver {
    val shipmentID by mutableStateOf(shipment.id)
    var shipmentNotes by mutableStateOf(shipment.notes)
        private set
    var shipmentUpdateHistory by mutableStateOf(shipment.updateHistory)
        private set
    var shipmentExpectedDelivery by mutableStateOf(shipment.expectedDelivery)
        private set
    var shipmentStatus by mutableStateOf(shipment.status)
        private set
    var shipmentLocation by mutableStateOf(shipment.currentLocation)
        private set
    val shipmentType by mutableStateOf(shipment.shipmentType)

    init {
        shipment.subscribe(this)
    }

    override fun notify(shipment: Shipment){
        this.shipment = shipment
        shipmentNotes = shipment.notes
        shipmentUpdateHistory = shipment.updateHistory
        shipmentStatus = shipment.status
        shipmentLocation = shipment.currentLocation
        shipmentExpectedDelivery = shipment.expectedDelivery
    }

    fun unsub(){
        shipment.unsubscribe(this)
    }

}