class FloatNumberState(detector: FloatDetector) : FloatState(detector) {
    override val isAccepting: Boolean
        get() = false

    override fun consumeInput(string: String) {

        if (string in "0123456789") {
            detector.state = FloatNumberState(detector)
        }
        else if (string in "."){
            detector.state = FloatDecimalState(detector)
        } else {
            detector.state = InvalidState(detector)
        }
    }
}