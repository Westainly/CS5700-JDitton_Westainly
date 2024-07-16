import kotlin.test.*

class TrackerViewHelperTest {

    @Test
    fun testTrackShipment() {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("created", "12345", 1234567890L)
        simulator.processUpdate(update)
        val viewHelper = TrackerViewHelper()
        viewHelper.trackShipment("12345", simulator)
        assertEquals("12345", viewHelper.shipmentId.value)
        assertEquals("created", viewHelper.shipmentStatus.value)
    }

    @Test
    fun testStopTracking() {
        val viewHelper = TrackerViewHelper()
        viewHelper.stopTracking()
        assertEquals("", viewHelper.shipmentId.value)
        assertTrue(viewHelper.shipmentNotes.value.isEmpty())
        assertTrue(viewHelper.shipmentUpdateHistory.value.isEmpty())
        assertEquals("", viewHelper.expectedShipmentDeliveryDate.value)
        assertEquals("", viewHelper.shipmentStatus.value)
    }

    @Test
    fun testOnShipmentUpdate() {
        val shipment = Shipment("12345")
        shipment.status = "shipped"
        shipment.addNote("Test note")
        shipment.addUpdate(ShipmentUpdate("shipped", "12345", 1234567890L, "1234567891"))
        val viewHelper = TrackerViewHelper()
        viewHelper.onShipmentUpdate(shipment)
        assertEquals("shipped", viewHelper.shipmentStatus.value)
        assertEquals("12345", viewHelper.shipmentId.value)
        assertEquals(1, viewHelper.shipmentNotes.value.size)
        assertEquals("Test note", viewHelper.shipmentNotes.value[0])
        assertEquals(1, viewHelper.shipmentUpdateHistory.value.size)
        assertEquals("Shipment went from shipped to shipped on 1234567890", viewHelper.shipmentUpdateHistory.value[0])
        assertEquals("1234567891", viewHelper.expectedShipmentDeliveryDate.value)
    }
}
