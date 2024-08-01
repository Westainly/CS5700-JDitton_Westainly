package org.example

class SetA: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.setA((firstByte.toInt() and 0xF) + secondByte.toInt())
    }
}