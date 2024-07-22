class DelayedShippingUpdate: ShippingUpdate {
    override var previousStatus: String = ""
    override var newStatus: String = ""
    override var timeStamp: Long = 0

    override fun update(
        updateType: String,
        shipmentId: String,
        updateTimeStamp: Long,
        otherInfo: String?
    ) {
        val shipment = TrackingSimulator.findShipment(shipmentId)
        if (shipment != null) {
            //Update variables
            previousStatus = shipment.status
            newStatus = updateType
            timeStamp = updateTimeStamp

            //Shipment variables
            shipment.status = newStatus
            if (otherInfo != null) {
                shipment.expectedDelivery = otherInfo.toLong()
            }
            shipment.updateHistory.add(this)
        }
    }
}
