import kotlin.test.*

class ShipmentUpdateTest {

    @Test
    fun testShipmentUpdateCreation() {
        val update = ShipmentUpdate("created", "12345", 1234567890L)
        assertEquals("created", update.updateType)
        assertEquals("12345", update.shipmentId)
        assertEquals(1234567890L, update.timestamp)
        assertEquals(null, update.otherInfo)
    }

    @Test
    fun testShipmentUpdateWithOtherInfo() {
        val update = ShipmentUpdate("shipped", "12345", 1234567890L, "expectedDelivery")
        assertEquals("shipped", update.updateType)
        assertEquals("12345", update.shipmentId)
        assertEquals(1234567890L, update.timestamp)
        assertEquals("expectedDelivery", update.otherInfo)
    }
}
