class EmailStartState(detector: EmailDetector) : EmailState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in " @"){
            detector.state = InvalidState(detector)
        }else{
            detector.state = EmailPart1State(detector)
        }
    }
}