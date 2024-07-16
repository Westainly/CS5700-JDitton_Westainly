class NoteAddedStrategy : UpdateStrategy {
    override fun processUpdate(shipment: Shipment, update: ShipmentUpdate) {
        shipment.addNote(update.otherInfo ?: "")
    }
}
