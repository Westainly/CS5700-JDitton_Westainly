class BulkShipment(status: String, id: String) : Shipment(status, id) {
    override var shipmentType = ShipmentType.Bulk
    override var expectedDelivery: Long = 0
        set(value){
            if (value >= getCreationTime() + DAYS3) {
                field = value
                notifySubs()
            }
            else {
                throw Error("Outside of range for expected delivery - Must be at least 3 days from creation")
            }
        }
}