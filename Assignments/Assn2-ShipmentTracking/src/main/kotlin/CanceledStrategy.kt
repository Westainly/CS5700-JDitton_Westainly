class CanceledStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.status = "canceled"
    }
}
