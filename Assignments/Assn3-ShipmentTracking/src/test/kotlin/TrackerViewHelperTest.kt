import kotlin.test.*

internal class TrackerViewHelperTest {
    @Test
    fun notifyTest(){
        CreatedShippingUpdate().update("created", "1002", 1)
        val shipment = TrackingSimulator.findShipment("1002")
        val tracker = shipment?.let { TrackerViewHelper(it) }

        if (shipment != null) {
            if (tracker != null) {
                assertEquals(tracker.shipmentNotes, shipment.notes)
            }
        }

        NoteAddedShippingUpdate().update("note", "1002", 0, "Testing notify")

        if (tracker != null) {
            assertEquals(tracker.shipmentNotes, shipment.notes)
        }

        LocationShippingUpdate().update("location", "1002", 0, "New Location?")

        if (tracker != null) {
            assertEquals(tracker.shipmentLocation, "New Location?")
        }

    }

}
