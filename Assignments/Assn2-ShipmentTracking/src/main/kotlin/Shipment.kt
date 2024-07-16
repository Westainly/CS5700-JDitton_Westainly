data class Shipment(
    val id: String,
    var status: String,
    var expectedDeliveryDateTimestamp: Long?,
    var currentLocation: String?,
    private val notes: MutableList<String> = mutableListOf(),
    private val updateHistory: MutableList<ShipmentUpdate> = mutableListOf()
) {
    fun addNote(note: String) {
        notes.add(note)
    }

    fun addUpdate(update: ShipmentUpdate) {
        updateHistory.add(update)
        status = update.newStatus
    }

    fun getNotes(): List<String> = notes
    fun getUpdateHistory(): List<ShipmentUpdate> = updateHistory
}