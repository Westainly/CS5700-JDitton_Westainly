import kotlinx.coroutines.delay

interface ShipmentObserver {
    fun onShipmentUpdated(shipment: Shipment)
}


class TrackingSimulatorObserver {
    private val shipments = mutableListOf<Shipment>()
    private val observers = mutableListOf<ShipmentObserver>()

    fun addObserver(observer: ShipmentObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: ShipmentObserver) {
        observers.remove(observer)
    }

    fun notifyObservers(shipment: Shipment) {
        observers.forEach { it.onShipmentUpdated(shipment) }
    }

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    suspend fun runSimulation(updates: List<String>) {
        for (update in updates) {
            processUpdate(update)
            delay(1000)
        }
    }

    private fun processUpdate(update: String) {
        // Parse and apply the update to the appropriate shipment
        // Notify observers about the update
        notifyObservers(shipment)
    }
}