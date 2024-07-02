import kotlin.test.*

class PointTests {
    @Test
    fun testPoint() {
        val point = Point(1.0, 2.0)
        assertEquals(1.0, point.x)
        assertEquals(2.0, point.y)

        val clonedPoint = point.clone()
        assertEquals(1.0, clonedPoint.x)
        assertEquals(2.0, clonedPoint.y)

        point.move(1.0, 1.0)
        assertEquals(2.0, point.x)
        assertEquals(3.0, point.y)
    }
}