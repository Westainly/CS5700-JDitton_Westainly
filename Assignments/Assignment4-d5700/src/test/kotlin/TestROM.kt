import org.example.ROM
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestROM {

    @OptIn(ExperimentalUnsignedTypes::class)
    @Test
    fun TestLoadInMemory()
    {
        val rom = ROM()
        rom.load(ubyteArrayOf(1u,2u,3u,4u,5u))
        assertEquals(1u, rom.read(0))
        assertEquals(0u, rom.read(5))
    }

    @Test
    fun TestOutOfBoundsReadAndWrite()
    {
        val rom = ROM()
        assertFailsWith<IllegalArgumentException>{rom.write(12311, 8u)}
        assertFailsWith<IllegalArgumentException>{rom.read(12311)}

    }
}