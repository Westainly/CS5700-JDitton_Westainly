data class ShipmentUpdate(
    val previousStatus: String,
    val newStatus: String,
    val timestamp: Long,
    val updateType: String,
    val shipmentId: String,
    val otherInfo: String = ""
)
