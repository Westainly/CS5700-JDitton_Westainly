class CreatedStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.status = "created"
    }
}
