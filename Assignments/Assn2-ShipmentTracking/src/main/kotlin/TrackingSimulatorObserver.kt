import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap

class TrackingSimulatorObserver {
    private val observers = mutableListOf<TrackingObserver>()
    private val shipments = ConcurrentHashMap<String, Shipment>()

    fun addObserver(observer: TrackingObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: TrackingObserver) {
        observers.remove(observer)
    }

    fun processUpdate(update: ShipmentUpdate) {
        val shipment = shipments.computeIfAbsent(update.shipmentId) { Shipment(update.shipmentId) }
        val strategy: UpdateStrategy = when (update.updateType) {
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
        shipment.addUpdate(update)
        notifyObservers(shipment)
    }

    private fun notifyObservers(shipment: Shipment) {
        observers.forEach { it.onShipmentUpdate(shipment) }
    }

    fun runSimulation(updates: List<ShipmentUpdate>) {
        CoroutineScope(Dispatchers.Default).launch {
            for (update in updates) {
                processUpdate(update)
                delay(1000L)
            }
        }
    }

    fun findShipment(id: String): Shipment? {
        return shipments[id]
    }
}
