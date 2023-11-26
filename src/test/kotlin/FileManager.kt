import java.io.File

object FileManager {

    fun String.readText() = File(this).readText()

    fun String.readLines() = File(this).readLines()
}