package example

import FileManager.readLines
import FileManager.readText
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example {

    @Test
    fun example_response_read_text() {
        val input = "./src/test/kotlin/example/InputExample".readText()
        val expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla blandit elit ligula, ut malesuada odio varius eu. Pellentesque sed justo magna. Vestibulum nulla justo, tristique ut mauris id, interdum tincidunt metus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec at ultricies justo. Quisque porta nibh non dapibus cursus. Aliquam id orci ac est rutrum rhoncus non ut eros. Maecenas et egestas velit, non accumsan velit. Mauris nulla felis, finibus eu varius quis, hendrerit at velit. Sed in diam ut enim cursus ultricies. Suspendisse egestas purus elit, non molestie nisi efficitur quis. Nulla ultrices et ligula vitae gravida. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris a sodales velit."
        assertEquals(expected, input)
    }
    @Test
    fun example_response_read_lines() {
        val input = "./src/test/kotlin/example/InputExample2".readLines()
        val expected = listOf(
            "test",
            "test2",
            "test3",
            "test4",
        )
        assertEquals(expected, input)
    }
}