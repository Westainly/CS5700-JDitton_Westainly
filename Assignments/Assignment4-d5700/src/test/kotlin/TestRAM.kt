import org.example.RAM
import kotlin.test.Test
import kotlin.test.assertFailsWith

class TestRAM {

    @Test
    fun TestOutOfBoundsReadAndWrite()
    {
        val ram = RAM()
        assertFailsWith<IllegalArgumentException>{ram.write(12311, 8u)}
        assertFailsWith<IndexOutOfBoundsException>{ram.read(12311)}
    }
}