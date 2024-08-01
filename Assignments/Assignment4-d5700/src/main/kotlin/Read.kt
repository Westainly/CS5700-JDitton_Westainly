package org.example

class Read: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.read(firstByte.toInt() and 0xF)
    }
}