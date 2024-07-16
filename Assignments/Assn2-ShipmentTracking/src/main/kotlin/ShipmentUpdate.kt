data class ShipmentUpdate(
    val updateType: String,
    val shipmentId: String,
    val timestamp: Long,
    val otherInfo: String? = null
)