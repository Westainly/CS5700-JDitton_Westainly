interface ShipmentUpdateStrategy {
    fun update(shipment: Shipment, data: List<String>)
}