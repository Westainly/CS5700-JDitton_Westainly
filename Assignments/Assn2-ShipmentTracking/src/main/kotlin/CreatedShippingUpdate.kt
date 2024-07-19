class CreatedShippingUpdate: ShippingUpdate {
    override val previousStatus: String = ""
    override val newStatus: String = ""
    override var timeStamp: Long = 0

    override fun update(
        updateType: String,
        shipmentId: String,
        updateTimeStamp: Long,
        otherInfo: String?
    ) {
        val shipment = Shipment(updateType, shipmentId)
        TrackingSimulator.addShipment(shipment)
        timeStamp = updateTimeStamp
    }
}
