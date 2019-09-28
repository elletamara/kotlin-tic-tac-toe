package board

internal class Square(private var value: String) {

    fun setValue(newValue: String) { value = newValue }

    fun getValue() = value

    fun copy() = Square(getValue())
}
