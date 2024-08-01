package org.example

class Write: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.write(firstByte.toInt() and 0xF)
    }
}