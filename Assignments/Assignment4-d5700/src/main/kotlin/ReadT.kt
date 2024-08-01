package org.example

class ReadT: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.modifyRegister(firstByte.toInt() and 0xF, computerFacade.getT().toUByte())
    }
}