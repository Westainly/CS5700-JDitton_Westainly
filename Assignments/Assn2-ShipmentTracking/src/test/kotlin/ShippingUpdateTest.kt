import kotlin.test.*

internal class ShippingUpdateTest {

    @Test
    fun testUpdateShippingLabel(){
        assertNull(TrackingSimulator.findShipment("10001"))

        CreatedShippingUpdate().update("created", "10001", 0)

        assertNotNull(TrackingSimulator.findShipment("10001"))

        ShippedShippingUpdate().update("update", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 1)

        ShippedShippingUpdate().update("update", "10001", 3, "2")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 2)

        NoteAddedShippingUpdate().update("noteAdded", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 3)

        NoteAddedShippingUpdate().update("noteAdded", "10001", 0, "Note is here :D")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 4)

        assertEquals(TrackingSimulator.findShipment("10001")?.notes?.size, 1)

        DelayedShippingUpdate().update("delayed", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 5)

        DelayedShippingUpdate().update("delayed", "10001", 0, "3")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 6)

        LocationShippingUpdate().update("location", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 7)

        LocationShippingUpdate().update("location", "10001", 0, "LA California!")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 8)

        CanceledShippingUpdate().update("canceled", "10001", 606060)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 9)

        DeliveredShippingUpdate().update("delivered", "10001", 60510)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 10)

        LostShippingUpdate().update("lost", "10001", 5019399)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 11)
    }

}
