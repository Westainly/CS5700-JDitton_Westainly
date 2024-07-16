class LocationStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.currentLocation = update.otherInfo ?: ""
    }
}
