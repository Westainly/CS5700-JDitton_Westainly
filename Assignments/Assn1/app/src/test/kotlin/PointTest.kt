import kotlin.test.*

internal class PointTests {

    @Test
    fun testPointCreation() {
        val point = Point(1.0, 2.0)
        assertEquals(1.0, point.xCoord)
        assertEquals(2.0, point.yCoord)
    }

    @Test
    fun testPointCreationZeros() {
        val point = Point(0.0, 0.0)
        assertEquals(0.0, point.xCoord)
        assertEquals(0.0, point.yCoord)
    }

    @Test
    fun testPointCreationNaN() {
        val point = Point(Double.NaN, 2.0)
        assertEquals(Double.NaN, point.xCoord)
        assertEquals(2.0, point.yCoord)
    }

    @Test
    fun testPointCloning() {
        val point = Point(1.0, 2.0)
        val clonedPoint = point.clone()
        assertEquals(1.0, clonedPoint.xCoord)
        assertEquals(2.0, clonedPoint.yCoord)
        assertEquals(point, clonedPoint)
    }

    @Test
    fun testPointMove() {
        val point = Point(1.0, 2.0)
        point.move(1.0, 1.0)
        assertEquals(2.0, point.xCoord)
        assertEquals(3.0, point.yCoord)
    }
}