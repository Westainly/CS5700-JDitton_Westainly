import kotlin.test.*

internal class TriangleTest {

    @Test
    fun testTriangleCreation() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(4.0, 1.0)
        val point3 = Point(2.0, 3.0)
        val triangle = Triangle(point1, point2, point3)

        assertEquals(Triple(point1, point2, point3), triangle.getPoints())
        assertEquals(3.0, triangle.getArea())
    }

    @Test
    fun testTriangleMoving() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(4.0, 1.0)
        val point3 = Point(2.0, 3.0)
        val triangle = Triangle(point1, point2, point3)
        
        triangle.move(1.0, 1.0)
        assertEquals(Triple(Point(2.0, 2.0), Point(5.0, 2.0), Point(3.0, 4.0)), triangle.getPoints())
    }

    @Test
    fun testTriangleWithCollinearPoints() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(2.0, 2.0)
        val point3 = Point(3.0, 3.0)
        
        assertFailsWith<IllegalArgumentException> {
            Triangle(point1, point2, point3)
        }
    }
}