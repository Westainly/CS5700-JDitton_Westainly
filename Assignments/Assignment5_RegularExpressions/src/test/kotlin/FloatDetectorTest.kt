import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FloatDetectorTest {

    @Test
    fun detect() {
        val detector = FloatDetector()
        assertTrue(detector.detect("1.0"))
        assertTrue(detector.detect("123.34"))
        assertTrue(detector.detect("0.20000"))
        assertTrue(detector.detect("12349871234.12340981234098"))
        assertTrue(detector.detect(".123"))


        assertFalse(detector.detect("123"))
        assertFalse(detector.detect("123.123."))
        assertFalse(detector.detect("123.02a"))
        assertFalse(detector.detect("123."))
        assertFalse(detector.detect("012.4"))
        assertFalse(detector.detect(""))

    }
}