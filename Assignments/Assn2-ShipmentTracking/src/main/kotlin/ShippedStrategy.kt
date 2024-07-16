class ShippedStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.status = "shipped"
        shipment.expectedDeliveryDateTimestamp = update.otherInfo.toLong()
    }
}
