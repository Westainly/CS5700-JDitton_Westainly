package org.example

class Jump: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        if ((((firstByte.toInt() and 0xF).toString(16) + (secondByte.toInt() shr 4).toString(16) + (secondByte.toInt() and 0xF).toString(16)).toInt(16)) % 2 != 0)
        {
            computerFacade.stop()
            throw IllegalArgumentException("Program counter needs to be even!")
        }
        computerFacade.setP((((firstByte.toInt() and 0xF).toString(16) + (secondByte.toInt() shr 4).toString(16) + (secondByte.toInt() and 0xF).toString(16)).toInt(16)))
    }
    
    override fun incrementCounter(computerFacade: Computer) {
    }
}