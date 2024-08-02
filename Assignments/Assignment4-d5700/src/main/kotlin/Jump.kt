package org.example

class Jump: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.setP((firstByte.toInt() and 0xF) + secondByte.toInt())
    }

    override fun incrementCounter(computerFacade: Computer) {
    }
}