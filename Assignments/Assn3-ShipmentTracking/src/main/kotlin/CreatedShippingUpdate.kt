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
        val shipment: Shipment = if (otherInfo != null) {
            TrackingSimulator.shipmentFactory.createShipment(shipmentId, Shipment.ShipmentType.valueOf(otherInfo))
        } else {
            TrackingSimulator.shipmentFactory.createShipment(shipmentId, Shipment.ShipmentType.Standard)
        }
        TrackingSimulator.addShipment(shipment)
        shipment.addUpdate(this)
        timeStamp = updateTimeStamp
    }
}
