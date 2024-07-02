import kotlin.test.*

internal class PointTests {

    @Test
    fun testPoint() {
        val point = Point(1.0, 2.0)
        assertEquals(1.0, point.xCoord)
        assertEquals(2.0, point.yCoord)

        val clonedPoint = point.clone()
        assertEquals(1.0, clonedPoint.xCoord)
        assertEquals(2.0, clonedPoint.yCoord)
        assertEquals(point, clonedPoint)

        point.move(1.0, 1.0)
        assertEquals(2.0, point.xCoord)
        assertEquals(3.0, point.yCoord)
    }
}