import kotlin.test.*

class CircleTest {
    @Test
    fun testCircle() {
        val center = Point(2.0, 3.0)
        val radius = 4.0
        val circle = Circle(center, radius)

        assertEquals(Triple(center, radius, radius), circle.getAttributes())
        assertEquals(50.26548245743669, circle.getArea(), 0.0001)

        circle.move(1.0, 1.0)
        assertEquals(Triple(Point(3.0, 4.0), radius, radius), circle.getAttributes())
    }
}