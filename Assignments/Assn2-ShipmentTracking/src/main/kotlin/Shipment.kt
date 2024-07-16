class Shipment(val id: String) {
    var status: String = "created"
    var expectedDeliveryDateTimestamp: Long? = null
    var currentLocation: String = ""
    private val notes = mutableListOf<String>()
    private val updateHistory = mutableListOf<ShipmentUpdate>()

    fun addNote(note: String) {
        notes.add(note)
    }

    fun getNotes(): List<String> = notes

    fun addUpdate(update: ShipmentUpdate) {
        updateHistory.add(update)
    }

    fun getUpdateHistory(): List<ShipmentUpdate> = updateHistory
}
