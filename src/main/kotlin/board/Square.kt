package board

internal class Square(internal var value: String) {

    fun setValue(newValue: String) { value = newValue }

    fun getValue() = value

    fun copy() = Square(getValue())
}
