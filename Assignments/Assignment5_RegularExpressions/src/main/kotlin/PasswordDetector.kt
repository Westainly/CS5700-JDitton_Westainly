class PasswordDetector: Detector() {
    override var state: State = PasswordStartState(this)


    override fun detect(input: String): Boolean{
        val characters = input
            .trim()
            .split("")
            .drop(1)
            .dropLast(1)
            .toMutableList()

        for (character in characters){
            state.consumeInput(character)
        }
        val isAccepting = state.isAccepting
        state = PasswordStartState(this)
        return isAccepting
    }
}