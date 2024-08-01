package org.example

class SwitchMemory: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        computerFacade.switchMemory()
    }
}