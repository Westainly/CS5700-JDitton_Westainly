class ExpressShipment(status: String, id: String) : Shipment(status, id) {
    override var shipmentType = ShipmentType.Express
    override var expectedDelivery: Long = 0
        set(value){
            if (value <= getCreationTime() + DAYS3) {
                field = value
                notifySubs()
            }
            else {
                throw Error("Outside of range ro expected delivery - Must be at most 3 days from creation")
            }
        }
}