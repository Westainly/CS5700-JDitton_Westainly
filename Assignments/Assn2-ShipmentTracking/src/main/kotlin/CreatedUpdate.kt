class CreatedUpdate:ShipmentUpdateStrategy {
    override fun update(shipment: Shipment, data: List<String>) {
        shipment.addUpdate(ShipmentUpdate(null, "created", data[2].toLong()))
    }
}