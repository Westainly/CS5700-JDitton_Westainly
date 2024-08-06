abstract class State(detector: Detector) {


        abstract val isAccepting: Boolean

        abstract fun consumeInput(string: String)

}