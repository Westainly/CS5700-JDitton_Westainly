import kotlin.test.*

internal class ShippingUpdateTest {

    @Test
    fun testUpdateShippingLabel(){
        //Test all of the shipping updates and make sure they work
        assertNull(TrackingSimulator.findShipment("10001"))

        CreatedShippingUpdate().update("created", "10001", 0)

        assertNotNull(TrackingSimulator.findShipment("10001"))

        ShippedShippingUpdate().update("update", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 2)

        ShippedShippingUpdate().update("update", "10001", 3, "2")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 3)

        NoteAddedShippingUpdate().update("noteAdded", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 4)

        NoteAddedShippingUpdate().update("noteAdded", "10001", 0, "Note is here :D")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 5)

        assertEquals(TrackingSimulator.findShipment("10001")?.notes?.size, 1)

        DelayedShippingUpdate().update("delayed", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 6)

        DelayedShippingUpdate().update("delayed", "10001", 0, "3")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 7)

        LocationShippingUpdate().update("location", "10001", 0)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 8)

        LocationShippingUpdate().update("location", "10001", 0, "LA California!")

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 9)

        CanceledShippingUpdate().update("canceled", "10001", 606060)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 10)

        DeliveredShippingUpdate().update("delivered", "10001", 60510)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 11)

        LostShippingUpdate().update("lost", "10001", 5019399)

        assertEquals(TrackingSimulator.findShipment("10001")?.updateHistory?.size, 12)
    }

}
