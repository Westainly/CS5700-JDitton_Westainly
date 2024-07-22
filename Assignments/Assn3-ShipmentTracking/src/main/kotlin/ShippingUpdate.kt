interface ShippingUpdate{
    val previousStatus: String
    val newStatus: String
    val timeStamp: Long

    fun update(updateType: String, shipmentId: String, updateTimeStamp: Long, otherInfo: String? = null)
}
