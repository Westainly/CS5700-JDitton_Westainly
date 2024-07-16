class DelayedStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.expectedDeliveryDateTimestamp = update.otherInfo.toLong()
    }
}
