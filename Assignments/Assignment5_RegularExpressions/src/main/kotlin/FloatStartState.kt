class FloatStartState(detector: FloatDetector) : FloatState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {
        if (string in ".") {
            detector.state = FloatDecimalState(detector)
        } else if (string in "0") {
            detector.state = FloatZeroState(detector)
        } else if (string in "123456789") {
            detector.state = FloatNumberState(detector)
        } else {
            detector.state = InvalidState(detector)
        }
    }
}