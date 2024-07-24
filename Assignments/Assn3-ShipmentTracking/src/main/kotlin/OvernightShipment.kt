class OvernightShipment(status: String, id: String) : Shipment(status, id){
    override var shipmentType = ShipmentType.Overnight
    override var expectedDelivery: Long = 0
        set(value){
            if (value <= getCreationTime() + DAYS1) {
                field = value
                notifySubs()
            }
            else {
                throw Error("Outside of range for expected delivery - Must be maximum 1 day away")
            }
        }
}