import kotlin.test.*

class EllipseTest {
    @Test
    fun testEllipse() {
        val center = Point(2.0, 3.0)
        val radiusX = 4.0
        val radiusY = 5.0
        val ellipse = Ellipse(center, radiusX, radiusY)

        assertEquals(Triple(center, radiusX, radiusY), ellipse.getAttributes())
        assertEquals(62.83185307179586, ellipse.getArea(), 0.0001)

        ellipse.move(1.0, 1.0)
        assertEquals(Triple(Point(3.0, 4.0), radiusX, radiusY), ellipse.getAttributes())
    }
}