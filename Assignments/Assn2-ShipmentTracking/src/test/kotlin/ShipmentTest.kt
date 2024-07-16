import kotlin.test.*

class ShipmentTest {

    @Test
    fun testShipmentCreation() {
        val shipment = Shipment("12345")
        assertEquals("12345", shipment.id)
        assertEquals("created", shipment.status)
        assertEquals(null, shipment.expectedDeliveryDateTimestamp)
        assertEquals("", shipment.currentLocation)
        assertTrue(shipment.getNotes().isEmpty())
        assertTrue(shipment.getUpdateHistory().isEmpty())
    }

    @Test
    fun testAddNote() {
        val shipment = Shipment("12345")
        shipment.addNote("Test note")
        assertEquals(1, shipment.getNotes().size)
        assertEquals("Test note", shipment.getNotes()[0])
    }

    @Test
    fun testAddUpdate() {
        val shipment = Shipment("12345")
        val update = ShipmentUpdate("created", "12345", 1234567890L)
        shipment.addUpdate(update)
        assertEquals(1, shipment.getUpdateHistory().size)
        assertEquals(update, shipment.getUpdateHistory()[0])
    }
}
