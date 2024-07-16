import kotlinx.coroutines.delay

class TrackingSimulator {
    private val shipments = mutableListOf<Shipment>()

    fun findShipment(id: String): Shipment? {
        return shipments.find { it.id == id }
    }

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    suspend fun runSimulation(updates: List<String>) {
        for (update in updates) {
            processUpdate(update)
            delay(1000) // Process one update per second
        }
    }

    private fun processUpdate(update: String) {
        // Parse and apply the update to the appropriate shipment
        // Implementation based on the update format provided
    }
}

