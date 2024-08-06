import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntegerDetectorTest {

    @Test
    fun detect() {
        val detector = IntegerDetector()
        assertTrue(detector.detect("123"))
        assertTrue(detector.detect("10983275409812374012938"))
        assertTrue(detector.detect("1"))
        
        assertFalse(detector.detect("0"))
        assertFalse(detector.detect(""))
        assertFalse(detector.detect("0123"))
        assertFalse(detector.detect("123a4"))
    }
}