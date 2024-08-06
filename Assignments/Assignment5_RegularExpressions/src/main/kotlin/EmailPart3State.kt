class EmailPart3State(detector: EmailDetector) : EmailState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "@. "){
            detector.state = InvalidState(detector)
        } else {
            detector.state = EmailValidState(detector)
        }
    }
}