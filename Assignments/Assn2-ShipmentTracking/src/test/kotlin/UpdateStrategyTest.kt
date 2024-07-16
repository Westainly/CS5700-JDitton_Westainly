import kotlin.test.*

class UpdateStrategyTest {

    @Test
    fun testCreatedStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("created", "12345", 1234567890L)
        val strategy = CreatedStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("created", shipment.status)
    }

    @Test
    fun testShippedStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("shipped", "12345", 1234567890L, "1234567891")
        val strategy = ShippedStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("shipped", shipment.status)
        assertEquals(1234567891L, shipment.expectedDeliveryDateTimestamp)
    }

    @Test
    fun testLocationStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("location", "12345", 1234567890L, "New York")
        val strategy = LocationStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("New York", shipment.currentLocation)
    }

    @Test
    fun testDeliveredStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("delivered", "12345", 1234567890L)
        val strategy = DeliveredStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("delivered", shipment.status)
    }

    @Test
    fun testDelayedStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("delayed", "12345", 1234567890L, "1234567891")
        val strategy = DelayedStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals(1234567891L, shipment.expectedDeliveryDateTimestamp)
    }

    @Test
    fun testLostStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("lost", "12345", 1234567890L)
        val strategy = LostStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("lost", shipment.status)
    }

    @Test
    fun testCanceledStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("canceled", "12345", 1234567890L)
        val strategy = CanceledStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals("canceled", shipment.status)
    }

    @Test
    fun testNoteAddedStrategy() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("noteadded", "12345", 1234567890L, "Test note")
        val strategy = NoteAddedStrategy()
        strategy.processUpdate(shipment, update)
        assertEquals(1, shipment.getNotes().size)
        assertEquals("Test note", shipment.getNotes()[0])
    }
}
