import kotlinx.coroutines.*
import java.io.File

object TrackingSimulator {
    val shipmentFactory = ShipmentFactory()

    private val shipments = mutableListOf<Shipment>()
    private val shippingUpdates = mapOf(
        Pair("created", CreatedShippingUpdate()),
        Pair("shipped", ShippedShippingUpdate()),
        Pair("location", LocationShippingUpdate()),
        Pair("delayed", DelayedShippingUpdate()),
        Pair("noteadded", NoteAddedShippingUpdate()),
        Pair("lost", LostShippingUpdate()),
        Pair("canceled", CanceledShippingUpdate()),
        Pair("delivered", DeliveredShippingUpdate()),
    )

    fun findShipment(id: String): Shipment? {
        val shipment: Shipment? = shipments.find { it.id == id }
        return shipment
    }

    fun addShipment(shipment: Shipment){
        shipments.add(shipment)
    }

    fun executeCommand(commandString: String) {
        val command = commandString.split(",")
        if (command.size == 3){
            shippingUpdates[command[0]]?.update(command[0], command[1], command[2].toLong())
        } else if (command.size == 4){
            shippingUpdates[command[0]]?.update(command[0], command[1], command[2].toLong(), command[3])
        }
    }
}