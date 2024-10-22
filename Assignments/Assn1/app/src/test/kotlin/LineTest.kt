import kotlin.test.*

internal class LineTest {
    
    @Test
    fun testLine() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(4.0, 5.0)
        val line = Line(point1, point2)

        assertEquals(Pair(point1, point2), line.getPoints())
        assertEquals(1.3333333333333333, line.getSlope())
        assertEquals(5.0, line.getLength())

        line.move(1.0, 1.0)
        assertEquals(Pair(Point(2.0, 2.0), Point(5.0, 6.0)), line.getPoints())
    }

    @Test
    fun testLineWithZeroLength() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(1.0, 1.0)
        
        assertFailsWith<IllegalArgumentException> {
            Line(point1, point2)
        }
    }

    @Test
    fun testLineWithNegativeLength() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(1.0, -3.0)
        val line = Line(point1, point2)
        
        assertEquals(Pair(point1, point2), line.getPoints())
        assertEquals(4.0, line.getLength()) 
    }

    @Test
    fun testLineWithZeroSlope() {
        val point1 = Point(1.0, 1.0)
        val point2 = Point(3.0, 1.0)
        val line = Line(point1, point2)
        
        assertEquals(0.0, line.getSlope()) 
    }
}