class StrategyContext {
    private val strategies = mapOf(
        "created" to CreatedUpdate(),
        "shipped" to ShippedUpdate()
        // other strategies...
    )

    fun applyStrategy(updateType: String, shipment: Shipment, data: List<String>) {
        strategies[updateType]?.update(shipment, data)
    }
}