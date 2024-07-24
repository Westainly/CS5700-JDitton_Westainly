import kotlin.test.*

class FactoryTest {

    @Test
    fun createStandardShipment(){
        CreatedShippingUpdate().update("created", "s01", 100000)

        val shipment = TrackingSimulator.findShipment("s01")

        shipment?.expectedDelivery = 100000000000
    }

    @Test
    fun createExpressShipment(){
        CreatedShippingUpdate().update("created", "s02", 100000, "Express")

        val shipment = TrackingSimulator.findShipment("s02")

        assertFails{shipment?.expectedDelivery = 100000000000}

        shipment?.expectedDelivery = 100001
    }

    @Test
    fun createBulkShipment(){
        CreatedShippingUpdate().update("created", "s03", 100000, "Bulk")

        val shipment = TrackingSimulator.findShipment("s03")

        assertFails{shipment?.expectedDelivery = 100001}

        shipment?.expectedDelivery = 100000000000
    }

    @Test
    fun createOvernightShipment(){
        CreatedShippingUpdate().update("created", "s04", 100000, "Overnight")

        val shipment = TrackingSimulator.findShipment("s04")

        assertFails{shipment?.expectedDelivery = 10000000000}

        shipment?.expectedDelivery = 100001
    }
}