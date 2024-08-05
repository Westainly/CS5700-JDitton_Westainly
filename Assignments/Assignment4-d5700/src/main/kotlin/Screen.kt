package org.example
@OptIn(ExperimentalUnsignedTypes::class)

class Screen {

    private var display: UByteArray = UByteArray(64)
    fun drawToScreen(rX: UByte, row: Int, column: Int)
    {
        this.display[row*8+column] = rX
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

    fun getScreenValue(row: Int, column: Int): UByte
    {
        if (row * 8 + column >= this.display.size)
        {
            throw IllegalArgumentException("Out of bounds for screen")
        }
        return this.display[row * 8 + column]
    }
}