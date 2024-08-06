class FloatDecimalState(detector: FloatDetector) : FloatState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {

        if (string in "0123456789") {
            detector.state = FloatValidState(detector)
        } else {
            detector.state = InvalidState(detector)
        }
    }
}