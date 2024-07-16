class DeliveredStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.status = "delivered"
    }
}
