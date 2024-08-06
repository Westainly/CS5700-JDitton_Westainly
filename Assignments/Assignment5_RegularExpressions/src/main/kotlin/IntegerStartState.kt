class IntegerStartState(detector: IntegerDetector) : IntegerState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in "123456789") {
            detector.state = IntegerValidState(detector)
        } else {
            detector.state = InvalidState(detector)
        }
    }
}