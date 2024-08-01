package org.example
@OptIn(ExperimentalUnsignedTypes::class)

class Screen {

    private var display: UByteArray = UByteArray(64)
    fun drawToScreen(rX: UByte, row: Int, column: Int)
    {
        try {
            this.display[row * 8 + column] = rX
        }
        catch (e : Exception)
        {
            println("Attempted to draw to screen: $e")
        }
        displayScreen()
    }
    private fun displayScreen()
    {
        var counter = 0
        println("========")
        for (item in display)
        {
            print(item.toInt().toChar())
            counter += 1
            if (counter == 8)
            {
                println()
                counter = 0
            }
        }
    }
}