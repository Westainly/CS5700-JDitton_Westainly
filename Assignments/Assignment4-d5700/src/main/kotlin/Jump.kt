package org.example

class Jump: InstructionTemplate() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        //println("Setting the p value to ${((firstByte.toInt() and 0xF).toHexString() + secondByte.toHexString()).toUByte()}")
        computerFacade.setP((firstByte.toInt() and 0xF) + secondByte.toInt())
    }

    override fun incrementCounter(computerFacade: Computer) {
    }
}