package org.example

class Store: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.modifyRegister(firstByte.toInt(), secondByte)
    }
}