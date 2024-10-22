class Shipment(
    var status: String,
    val id: String,
) {
    var currentLocation: String = ""
        set(value) {
            field = value
            notifySubs()
        }
    val notes = mutableListOf<String>()
    val updateHistory = mutableListOf<ShippingUpdate>()
    var expectedDelivery: Long = 0
        set(value) {
            field = value
            notifySubs()
        }

    private val subscribers = mutableListOf<ShipmentObserver>()

    fun subscribe(observer: ShipmentObserver){
       subscribers.add(observer)
    }

    fun unsubscribe(observer: ShipmentObserver){
        subscribers.remove(observer)
    }

    private fun notifySubs(){
        subscribers.forEach {
            it.notify(this)
        }
    }

    fun addNotes(note: String){
        notes.add(note)
        notifySubs()
    }

    fun addUpdate(update: ShippingUpdate){
        updateHistory.add(update)
        notifySubs()
    }


}