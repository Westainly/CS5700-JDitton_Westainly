class EmailPart2State(detector: EmailDetector) : EmailState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "@ "){
            detector.state = InvalidState(detector)
        } else if (string in "."){
            detector.state = EmailPart3State(detector)
        }
    }
}