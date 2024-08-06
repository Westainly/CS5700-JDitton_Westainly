abstract class Detector {
    abstract var state: State

    abstract fun detect(input: String): Boolean
}