class TrackingSimulatorObserver {
    private val observers = mutableListOf<TrackingObserver>()
    private val shipments = mutableMapOf<String, Shipment>()

    fun addObserver(observer: TrackingObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: TrackingObserver) {
        observers.remove(observer)
    }

    fun notifyObservers(shipment: Shipment) {
        observers.forEach { it.onShipmentUpdate(shipment) }
    }

    suspend fun processUpdate(update: ShipmentUpdate) {
        val shipment = shipments[update.shipmentId] ?: if (update.updateType == "created") {
            Shipment(update.shipmentId, update.updateType).also { shipments[update.shipmentId] = it }
        } else {
            return // Skip updates for non-existing shipments
        }

        val previousStatus = shipment.status
        val strategy = when (update.updateType) {
            "created" -> CreatedStrategy()
            "shipped" -> ShippedStrategy()
            "location" -> LocationStrategy()
            "delivered" -> DeliveredStrategy()
            "delayed" -> DelayedStrategy()
            "lost" -> LostStrategy()
            "canceled" -> CanceledStrategy()
            "noteadded" -> NoteAddedStrategy()
            else -> throw IllegalArgumentException("Unknown update type: ${update.updateType}")
        }

        strategy.processUpdate(shipment, update)
        shipment.addUpdate(update.copy(previousStatus = previousStatus, newStatus = shipment.status))
        notifyObservers(shipment)
    }

    fun findShipment(id: String): Shipment? {
        return shipments[id]
    }

    fun getAllShipments(): List<Shipment> {
        return shipments.values.toList()
    }
}
