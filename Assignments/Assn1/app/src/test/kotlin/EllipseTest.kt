import kotlin.test.*

internal class EllipseTest {
    
    @Test
    fun testEllipseCreation() {
        val center = Point(2.0, 3.0)
        val radiusX = 4.0
        val radiusY = 5.0
        val ellipse = Ellipse(center, radiusX, radiusY)

        assertEquals(Triple(center, radiusX, radiusY), ellipse.getAttributes())
        assertEquals(62.83185307179586, ellipse.getArea(), 0.0001)
    }

    @Test
    fun testEllipseMoving() {
        val center = Point(2.0, 3.0)
        val radiusX = 4.0
        val radiusY = 5.0
        val ellipse = Ellipse(center, radiusX, radiusY)

        ellipse.move(1.0, 1.0)
        assertEquals(Triple(Point(3.0, 4.0), radiusX, radiusY), ellipse.getAttributes())
    }

    @Test
    fun testEllipseWithZeroRadiusY() {
        val center = Point(2.0, 3.0)
        
        assertFailsWith<IllegalArgumentException> {
            Ellipse(center, 4.0, 0.0)
        }
    }

    @Test
    fun testEllipseWithZeroRadiusX() {
        val center = Point(2.0, 3.0)
        
        assertFailsWith<IllegalArgumentException> {
            Ellipse(center, 0.0, 5.0)
        }
    }
}