data class Shipment(
    val id: String,
    var status: String,
    var currentLocation: String = "",
    var expectedDeliveryDateTimestamp: Long = 0L,
    private val notes: MutableList<String> = mutableListOf(),
    private val updateHistory: MutableList<ShipmentUpdate> = mutableListOf()
) {
    fun addNote(note: String) {
        notes.add(note)
    }

    fun getNotes(): List<String> = notes

    fun addUpdate(update: ShipmentUpdate) {
        updateHistory.add(update)
    }

    fun getUpdateHistory(): List<ShipmentUpdate> = updateHistory
}
