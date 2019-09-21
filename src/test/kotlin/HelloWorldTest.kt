import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class HelloWorldTest {

    @Test
    fun returnsHelloWorld() {
        var helloWorld = HelloWorld();

        assertEquals(helloWorld.hello(), "Hello World!")
    }
}
