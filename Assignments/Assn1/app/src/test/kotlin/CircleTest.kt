import kotlin.test.*

internal class CircleTest {

    @Test
    fun testCircleCreation() {
        val center = Point(2.0, 3.0)
        val radius = 4.0
        val circle = Circle(center, radius)

        assertEquals(Triple(center, radius, radius), circle.getAttributes())
        assertEquals(50.26548245743669, circle.getArea(), 0.0001)
    }

    @Test
    fun testCircleMoving() {
        val center = Point(2.0, 3.0)
        val radius = 4.0
        val circle = Circle(center, radius)
        
        circle.move(1.0, 1.0)
        assertEquals(Triple(Point(3.0, 4.0), radius, radius), circle.getAttributes())
    }
    
    @Test
    fun testCircleWithZeroRadius() {
        val center = Point(2.0, 3.0)
        
        assertFailsWith<IllegalArgumentException> {
            Circle(center, 0.0)
        }
    }
}