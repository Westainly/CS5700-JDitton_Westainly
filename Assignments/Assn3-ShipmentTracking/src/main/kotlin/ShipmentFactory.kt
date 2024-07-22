class ShipmentFactory {
    fun createShipment(id: String, type: Shipment.ShipmentType) = when (type) {
        Shipment.ShipmentType.Bulk -> BulkShipment("created", id)
        Shipment.ShipmentType.Express -> ExpressShipment("created", id)
        Shipment.ShipmentType.Standard -> StandardShipment("created", id)
        Shipment.ShipmentType.Overnight -> OvernightShipment("created", id)
    }
}