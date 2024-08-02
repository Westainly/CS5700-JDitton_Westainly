package org.example

class Draw: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.drawToScreen(firstByte.toInt() and 0xF, secondByte.toInt() shr 4,secondByte.toInt() and 0xF)
    }
}