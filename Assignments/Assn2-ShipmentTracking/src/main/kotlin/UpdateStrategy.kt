interface UpdateStrategy {
    fun processUpdate(shipment: Shipment, update: ShipmentUpdate)
}
