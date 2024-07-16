import kotlinx.coroutines.runBlocking
import kotlin.test.*

class TrackingSimulatorObserverTest {

    @Test
    fun testAddObserver() {
        val simulator = TrackingSimulatorObserver()
        val observer = object : TrackingObserver {
            override fun onShipmentUpdate(shipment: Shipment) {}
        }

        simulator.addObserver(observer)
        assertEquals(1, simulator.getObserversCount())
    }

    @Test
    fun testRemoveObserver() {
        val simulator = TrackingSimulatorObserver()
        val observer = object : TrackingObserver {
            override fun onShipmentUpdate(shipment: Shipment) {}
        }

        simulator.addObserver(observer)
        simulator.removeObserver(observer)
        assertEquals(0, simulator.getObserversCount())
    }

    @Test
    fun testProcessUpdateCreated() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("created", "12345", 1234567890L)
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("created", shipment?.status)
    }

    @Test
    fun testProcessUpdateShipped() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("shipped", "12345", 1234567890L, "1234567891")
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("shipped", shipment?.status)
        assertEquals(1234567891L, shipment?.expectedDeliveryDateTimestamp)
    }

    @Test
    fun testProcessUpdateLocation() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("location", "12345", 1234567890L, "Los Angeles CA")
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("Los Angeles CA", shipment?.currentLocation)
    }

    @Test
    fun testProcessUpdateDelivered() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("delivered", "12345", 1234567890L)
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("delivered", shipment?.status)
    }

    @Test
    fun testProcessUpdateDelayed() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("delayed", "12345", 1234567890L, "1234567892")
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("1234567892".toLong(), shipment?.expectedDeliveryDateTimestamp)
    }

    @Test
    fun testProcessUpdateLost() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("lost", "12345", 1234567890L)
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("lost", shipment?.status)
    }

    @Test
    fun testProcessUpdateCanceled() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("canceled", "12345", 1234567890L)
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertEquals("canceled", shipment?.status)
    }

    @Test
    fun testProcessUpdateNoteAdded() = runBlocking {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("noteadded", "12345", 1234567890L, "packaging was damaged slightly during shipping")
        simulator.processUpdate(update)

        val shipment = simulator.findShipment("12345")
        assertNotNull(shipment)
        assertTrue(shipment?.getNotes()?.contains("packaging was damaged slightly during shipping") ?: false)
    }

    @Test
    fun testProcessUpdateUnknownType() {
        val simulator = TrackingSimulatorObserver()
        val update = ShipmentUpdate("unknownType", "12345", 1234567890L)

        val exception = assertFailsWith<IllegalArgumentException> {
            runBlocking { simulator.processUpdate(update) }
        }
        assertEquals("Unknown update type: unknownType", exception.message)
    }
}
